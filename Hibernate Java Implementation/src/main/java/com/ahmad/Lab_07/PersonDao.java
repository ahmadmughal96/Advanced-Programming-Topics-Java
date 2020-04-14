package com.ahmad.Lab_07;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class PersonDao {
	private Session currSession = null;
	private SessionFactory myFactory = null;
	
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
	public void addPerson(Person person) {
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		currSession.save(person);
		tx.commit();
		
		currSession.close();
	}
	
	//Update person in database
	public void updatePerson(Person person) {
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		currSession.update(person);
		tx.commit();

		currSession.close();
	}
	
	//Delete person from database
	public void deletePerson(int id) {
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		Person person = (Person)currSession.get(Person.class, id); 
        currSession.delete(person); 
        tx.commit();

		currSession.close();
	}
	
	//display person
	public void getPerson(int id) {
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		Person person = (Person)currSession.get(Person.class, id); 
		
		System.out.println("ID: " + person.getId());
        System.out.println("Name: " + person.getName());
        System.out.println("Fathername: " + person.getFathername());
        System.out.println("Organization: " + person.getOrganization());
        System.out.println("Mobile: " + person.getMobile());
        tx.commit();

		currSession.close();
	}
	
}

