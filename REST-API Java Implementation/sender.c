#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <netinet/in.h>
#include <sys/time.h>
#include <time.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/sendfile.h>
#define PORT     25000
#define RECEIVER_ADDRESS  "127.0.0.1"
#define fileName    "my sending video.mp4"
#define bSIZE 500 //Buffer size in bytes

/* End Flag identifier */
char *END_FLAG = "===========this is the end";

struct packet{
	int seqNum; //Sequence number of packet
	char data[bSIZE]; //Data of bSize bytes
	int size; //Size of payload in data variable
};

int main(int argc, char **argv)
{
        int sender_socket;
        struct timespec tim, tim2;
        tim.tv_sec = 0;
        tim.tv_nsec = 500000L;
        int n;
        socklen_t     sock_length;
        ssize_t len;
        struct sockaddr_in      sender_address;
        int file_Desc;
        int recv_bytes = 0;
        off_t fileSize;
        struct stat file_stat;
        struct packet packets[5];
        int remain_data;
        struct timeval timeVal;
		timeVal.tv_sec = 0;
		timeVal.tv_usec = 1000000;
        int ack;
        int acks[5];
        int totalP;

        /* Creating sender socket */
        sender_socket = socket(AF_INET, SOCK_DGRAM, 0);

        /* Zeroing sender_address struct */
        memset(&sender_address, 0, sizeof(sender_address));
        /* Construct sender_address struct */
		//bzero(&sender_address, sizeof(sender_address));
        sender_address.sin_family = AF_INET;
        inet_pton(AF_INET, RECEIVER_ADDRESS, &sender_address.sin_addr);
        sender_address.sin_port = htons(PORT);
        sock_length = sizeof(struct sockaddr_in);
        
        /* Opening file with fileName as read-only*/
        file_Desc = open(fileName, O_RDONLY);
        
        /* Getting file statistics */
        fstat(file_Desc, &file_stat);
        
        /* Printing size of file to be sent*/
        fprintf(stdout, "File Size: \n%ld bytes\n", file_stat.st_size);
        
        /* Sending file size to receiver */
        fileSize = file_stat.st_size;
        sendto(sender_socket, &fileSize, sizeof(off_t), 0, (struct sockaddr *) &sender_address, sock_length);
        
        /* Setting timeout for sender_socket */
		setsockopt(sender_socket, SOL_SOCKET, SO_RCVTIMEO, &timeVal, sizeof(timeVal));
        
        /* Packet for receiving Acks */
        struct packet pkt;
        
        /* Reading file data into packets in a buffer array */
		n = 1;
        len = 1;
        totalP = 0;
    	for (int i = 0; i < 5; i++){
        	len = read(file_Desc, packets[i].data, bSIZE);
        	packets[i].seqNum = n;
        	packets[i].size = len;
        	n += 1;
            totalP++;
    	}
        
        /* Main loop for sending data receiving Acks and reading further data */
        while (len > 0 && n > 1) 
        {
            /* Resend tag */
            RESEND:
            
            /* Loop for sending packets in the buffer array */
        	for (int i = 0; i < 5; i++){
                /* Check if ack for that packet is received or not */
                if (acks[i]== 0){
                    printf("Sending packet %d\n", packets[i].seqNum);
                    sendto(sender_socket, &packets[i], sizeof(struct packet), 0, (struct sockaddr *) &sender_address, sock_length);
                    nanosleep(&tim, &tim2);
                }
            }
            
            /* Loop for receiving Acks */
            for (int i = 0; i < 5; i++){
            	ack = recvfrom(sender_socket, &pkt, sizeof(struct packet), 0, (struct sockaddr *)&sender_address , &sock_length);
                if (strcmp(pkt.data, "Ack") == 0 && ack > 0){
            		printf("Ack %d received\n", pkt.seqNum);
                    acks[pkt.seqNum - 1] = 1;
            	}else{
                    /* If Ack is not received */
                    goto RESEND;
                }
            }
            
            /* Zeroing array of Acks */
            memset(acks, 0, sizeof(acks));
            
            /* Zeroing array of packets */
            memset(packets, 0, sizeof(packets));
            
            /* Loop for reading next 5 packets */
            n = 1;
    		for (int i = 0; i < 5; i++){
        		len = read(file_Desc, packets[i].data, bSIZE);
                packets[i].seqNum = n;
                packets[i].size = len;
                n += 1;
                if (len > 0){
                    totalP++;
                }
    		}
   		}
        printf("Total packets: %d\n", totalP);
        /* Sending end flag packet */
   		struct packet end_pack;
        strcpy(end_pack.data, END_FLAG);
   		printf("Sending end flag\n");
		sendto(sender_socket, &end_pack, sizeof(struct packet), 0,  (struct sockaddr *) &sender_address, sock_length);
        
        /* Close socket */
        close(sender_socket);
        
        return 0;
}
