//Ahmad Amjad Mughal
//121672
//BSCS-6C

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

@Repository
public class PersonDao {
	@Autowired
	DBSession handler;
	private Session currSession = null;
	private SessionFactory myFactory = null;
	
	//Initializing session factory in constructor
	public PersonDao() {}
	
	
	//Closing connection
	public void finalize() {
		myFactory.close();
	}
	
	//Add person to database
	public void addPerson(Person person) {
		myFactory = handler.getSessionFactory();
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		currSession.save(person);
		tx.commit();
		
		currSession.close();
	}
	
	//Update person in database
	public void updatePerson(Person person) {
		myFactory = handler.getSessionFactory();
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		currSession.update(person);
		tx.commit();

		currSession.close();
	}
	
	//Delete person from database
	public void deletePerson(int id) {
		myFactory = handler.getSessionFactory();
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		Person person = (Person)currSession.get(Person.class, id); 
        currSession.delete(person); 
        tx.commit();

		currSession.close();
	}
	
	//display person
	public void getPerson(int id) {
		myFactory = handler.getSessionFactory();
		currSession = myFactory.openSession();
		Transaction tx = currSession.beginTransaction();
		Person person = (Person)currSession.get(Person.class, id); 
		
		System.out.println("ID: " + person.getId());
        System.out.println("Name: " + person.getName());
        System.out.println("Fathername: " + person.getFatherName());
        System.out.println("Organization: " + person.getOrganization());
        System.out.println("Mobile: " + person.getMobile());
        System.out.println("UserName "+ person.getUserName());
        System.out.println("Password "+ person.getPassword());
        tx.commit();

		currSession.close();
	}
}

