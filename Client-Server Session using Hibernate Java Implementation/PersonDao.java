//Ahmad Amjad Mughal
//121672
//BSCS-6C
//Assignment 2
package com.mughal.Assignment_2;

//Utilities and Dependencies 
import java.io.Serializable;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonDao {
	private Session currSession = null;
	private SessionFactory myFactory = null;
	ObjectMapper om = new ObjectMapper();
	
	
	//Initializing session factory in constructor
	public PersonDao() {
		SessionCreator.createSessionFactory();
		myFactory = SessionCreator.getSessionFactory();
	}
	
	//Closing connection
	public void finalize() {
		myFactory.close();
		SessionCreator.getServiceRegistry().close();
	}
	
	//Add person to database
	public String addPerson(Person person)  
	{
		String error;
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		try
		{
		currSession.save(person);
		error = "Record Registered with User Name "+ person.getUser() + " Successfully";
		tx.commit();
		}
		catch(ConstraintViolationException e2)
		{
			error = "Duplicate Key " + person.getUser() + " Found";
		}
		catch(PersistenceException e1)
		{
			error = "Duplicate Key " + person.getUser() + " Found";
		}
		
		
		currSession.close();
		return error;
	}
	
	//Update person in database
	public String updatePerson(Person person) {
		String update;
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		currSession.update(person);
		update = "Record: " + person.getUser() + " Updated";
		tx.commit();
		
		currSession.close();
		return update;
	}
	
	//Delete person from database
	public String deletePerson(String user_name) 
	{	
		String message;
		Serializable id = new String(user_name);
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		try
		{
			Person person = currSession.load(Person.class, id);	
			currSession.delete(person);
			message = "Person Record " + id + " is deleted";
		}
		catch(EntityNotFoundException e1)
		{
			message = "error: Record with the username " + id +" Not found";
		}
        tx.commit();
		currSession.close();
		return message;
	}
	
	//display person
	public String getPerson(String user_name) throws JsonProcessingException{
		String json;
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		try
		{
			Person person = (Person)currSession.get(Person.class, user_name); 
	
			System.out.println("First: " + person.getFirst_Name());
			System.out.println("Last: " + person.getLast_Name());
			System.out.println("Mobile: " + person.getMobile());
			System.out.println("User: " + person.getUser());
			System.out.println("Password: " + person.getPassword());
			System.out.println("Acess Level: " + person.getAcess_Level());	
		    json = "Success: "+ om.writeValueAsString(person);
		}
		catch(NullPointerException e)
		{
			json = "error: {"+ user_name + "} Not Found";
		}
		catch(EntityNotFoundException e1)
		{
			json = "error: {"+ user_name + "} Not Found"; 
		}
        tx.commit();

		currSession.close();
		return json;
	}
	
}
