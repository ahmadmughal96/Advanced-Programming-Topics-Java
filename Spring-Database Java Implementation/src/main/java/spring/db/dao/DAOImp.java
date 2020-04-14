package spring.db.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.db.model.Person;

@Repository
public class DAOImp {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Person> getAllPersons() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Person.class);
		List<Person> Persons = (List<Person>) criteria.list();
		session.getTransaction().commit();
		System.out.println(Persons.size());
		return Persons;
	}

	public void displaySchema(){
	}
	
	public List<Person> listPerson() {
		String hql = "from Person";
		Query query = getSessionFactory().openSession().createQuery(hql);
		return query.list();
	}

	public Person updatePerson(Person person) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(person);
		transaction.commit();
		return person;
	}

	public boolean deletePerson(long personId)
	{
		Session session = getSessionFactory().openSession();
		Object persistentInstance = session.load(Person.class, personId);
		if (persistentInstance != null) 
		{
			Transaction transaction = session.beginTransaction();
			session.delete((Person)persistentInstance );
			transaction.commit();
			return true;
		}
		return false;
	}

	public Person insterPerson(Person person) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(person);
		transaction.commit();
		return person;
	}

}
