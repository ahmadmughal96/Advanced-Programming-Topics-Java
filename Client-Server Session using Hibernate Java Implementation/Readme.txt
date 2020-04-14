Name: Ahmad Amjad Mughal
Class: BSCS-6C
Reg No: 121672

											ASSIGNMENT NO 2
								
							(Developing a Database Connectivity Client-Server Application using Hibernate) 
Client Role: First of all my approach is to ask client what type of operation he needs to perform. After selecting desired operation he adds the required attributes and set a Person instance
	     convert it into JSON String along with tag and sends it to server. When server performs it role, a responsive message send by the server is displayed on client side.

Server Role: Receives the required tag + JSON String and convert it into object and performs required query. Results are retured as a string to server and server sends that result to client.

Database Role: Hibernate maps the Person Object to Person record and do what clients wants. Exceptions are handeled when illegal operation is aim to perform.
	       Like Duplicate Key, Record not Found.