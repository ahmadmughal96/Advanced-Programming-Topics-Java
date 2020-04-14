//Ahmad Amjad Mughal
//121672
//BSCS-6C
//Assignment 2
package com.mughal.Assignment_2;

//Utilities and Dependencies 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;

//Client Main class that sends a JSON String + required tag to identify operation to perform by Server 
public class Client_Main 
{
	public static void main(String arg[]) throws UnknownHostException, IOException
	{
		//Creating required Instances on Client side and initialize them to null
		Scanner scan = new Scanner(System.in);
		System.out.println("1 for Insertion\n2 for Updation\n3 for Deletion\n4 for Retreival");
		int choice = scan.nextInt();
		String fromServer;
		DataInputStream inFromServer = null;
		Socket clientSocket = null;
		DataOutputStream outToServer = null;
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			clientSocket = new Socket("localhost", 6712);  //creating a connection via Socket with given IP.
		
			 outToServer = 
		          new DataOutputStream(clientSocket.getOutputStream());  //Instances of Input and Output Streams for data sending and receiving
			 inFromServer = 
			      new DataInputStream(clientSocket.getInputStream()); 
			 
			//choices for the user whether he selects addition or updation
			if(choice == 1 || choice == 2) 
			{		
				Person person = new Person();

				//Asking for Person attributes
				System.out.println("First Name: ");
				String first = scan.next();
		
				System.out.println("Last Name: ");
				String last = scan.next();
			
				System.out.println("Mobile_no: ");
				String mobile = scan.next();
			
				System.out.println("User_Name: ");
				String user = scan.next();
				
				System.out.println("Password: ");
				String password = scan.next();	
		
				System.out.println("Acess_Level: ");
				String acess = scan.next();
				
				//Assigning the values to Person attributes via setter methods
				person.setFirst_Name(first);
				person.setLast_Name(last);
				person.setMobile(mobile);
				person.setUser(user);
				person.setPassword(password);
				person.setAcess_Level(acess);
				
				switch(choice)
				{
					case 1:
					{
				
						System.out.println("----------Insertion---------\n");
						System.out.println("Following tags are available\n post\nEnter Tag:");
						String tag = scan.next();		
						
						//Convert the Person object to JSON String and concatenate a tag with it
						String string = mapper.writeValueAsString(person);
						String updated = tag + ": " + string;
						//send a JSON String to server
						outToServer.writeUTF(updated);
						break;
					}
					case 2:
					{
						
						System.out.println("----------Updation---------\n");
						System.out.println("Following tags are available\n put\nEnter Tag:");
						String tag = scan.next();		
				
						String string = mapper.writeValueAsString(person);
						String updated = tag + ": " + string;
						outToServer.writeUTF(updated);
					}
					default :
					{
						break;
					}
				}
			}
			if(choice == 3 || choice == 4)
			{
				System.out.println("Enter UserName: ");
				String user_name = scan.next();
			
				switch(choice)
				{
				case 3:
				{
					
					System.out.println("\n----------Deleteion---------\n");
					System.out.println("Following tags are available\n delete\nEnter Tag:");
					String tag = scan.next();
				
					String updated = tag + ": " + user_name;
					outToServer.writeUTF(updated);
					break;
				}
				case 4:
				{
					
					System.out.println("\n----------Retreival---------\n");								
					System.out.println("Following tags are available\n get\nEnter Tag:");
					String tag = scan.next();
					
					String updated = tag + ": " + user_name;
					outToServer.writeUTF(updated);
					break;
				}
				default:
						break;
				
			}
		}
			
	}
		catch(SocketException e1)
		{
			e1.printStackTrace();
		}
		finally
		{	
			//Waiting for the response message server sends to client after performing operation
			System.out.println("\nResponse from the Server: ");	
			//Read a string from send by the Server
			fromServer = inFromServer.readUTF();
			System.out.println(fromServer);	
			
		}
	}
}

