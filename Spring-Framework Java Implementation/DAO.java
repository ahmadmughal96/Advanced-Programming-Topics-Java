import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class DAO 
{

@Autowired
	private SessionFactory sessionFactory;
    private JdbcTemplate jdbctemplate;
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	public List<Person> getAllPersons() 
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Person.class);
		List<Person> Persons = (List<Person>) criteria.list();
		session.getTransaction().commit();
		System.out.println(Persons.size());
		return Persons;
	}
	/*public void create(Person person) 
	{
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
	}*/
	
	
}

