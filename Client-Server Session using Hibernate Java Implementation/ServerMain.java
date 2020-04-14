//Ahmad Amjad Mughal
//121672
//BSCS-6C
//Assignment 2
package com.mughal.Assignment_2;

//Utilities and Dependencies 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ServerMain 
{
	static String message;
	
	//Server class receives a JSON String that splits the Tag and Person string 
	public static void main(String[] args) throws IOException
	{
		//initialize the Instances of Input,Output Streams and ServerSocket 
		ObjectMapper mapper = new ObjectMapper();  
		String fromClient;
		PersonDao handler = new PersonDao();
		ServerSocket welcomeSocket = new ServerSocket(6712); 
		DataOutputStream toClient = null;
		DataInputStream inFromClient =  null;
	try{
		//creating connection via ServerSocket with Socket
		Socket connectSocket = welcomeSocket.accept(); 
			inFromClient = new DataInputStream(connectSocket.getInputStream());
            toClient = new DataOutputStream(connectSocket.getOutputStream());
            //Reads the required JSON String from client
            fromClient = inFromClient.readUTF();        
            //Splitt the string into two
            String[] tag = fromClient.split(": ");
            
            
            String string1 = tag[0];
            String string2 = tag[1];
            
            //Functions to execute if tag matches on of these conditions
            if(string1.equals("put"))
            {     
            	Person person = mapper.readValue(string2, Person.class);
            	message = handler.updatePerson(person);
        		handler.finalize();
        		
            }
            if(string1.equals ("post"))
            {
            	Person person = mapper.readValue(string2, Person.class);
            	message = handler.addPerson(person); 
            	handler.finalize();      
            }
            else
            if(string1.equals("delete"))
            {
            	message = handler.deletePerson(string2);
            	handler.finalize();
            }
            else
            if(string1.equals("get"))
            {
            	message = handler.getPerson(string2);
            	handler.finalize();
            	          	
            }
		}
	catch(Exception e) 
		{

			e.printStackTrace();

		}
	finally
		{
		//Send a reponse to client via WriteUTF method
		toClient.writeUTF(message);
		welcomeSocket.close();
		}
	}
	
}