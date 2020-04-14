import java.io.*; 
import java.net.*; 
import java.io.File;

public class TCPClient 
{
	public static void main(String argv[]) throws Exception
    { 
        String sentence; 
        String modifiedSentence; 
        FileReader file = null;
        file = new FileReader("C://Users//Ahmad Amjad Mughal//Desktop//File.txt");
        BufferedReader inFromUser = 
        		new BufferedReader(file);
        while((file.read()) != -1)
        {
        Socket clientSocket = new Socket("10.99.18.78", 6001);
        DataOutputStream outToServer = 
          new DataOutputStream(clientSocket.getOutputStream()); 
        BufferedReader inFromServer = 
        		new BufferedReader(new
                InputStreamReader(clientSocket.getInputStream())); 

              sentence = inFromUser.readLine(); 

              outToServer.writeBytes(sentence + '\n'); 

              modifiedSentence = inFromServer.readLine(); 

              System.out.println("FROM SERVER: " + modifiedSentence); 
              clientSocket.close();
        }                
     } 
} 


