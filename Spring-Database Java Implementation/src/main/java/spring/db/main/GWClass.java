package spring.db.main;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.db.dao.DAOImp;
import spring.db.model.Person;

public class GWClass {
	//
	private DAOImp hibernateDaoImp = null;
	public GWClass(String springPath){
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(springPath);
		applicationContext.registerShutdownHook(); 
		hibernateDaoImp = (DAOImp) applicationContext.getBean("hibernateDaoImp");		
	}
	public Person addPerson(Person person){
		return hibernateDaoImp.insterPerson(person);		
	}
	public List<Person> listPerson(){
		return hibernateDaoImp.listPerson();
	}

}
