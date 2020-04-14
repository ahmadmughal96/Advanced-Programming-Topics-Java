/**
 * 
 */
/**
 * 
 *
 */
package spring.db.main;
import java.util.List;

import spring.db.model.Person;


public class MainBean {


	public MainBean() {
		GWClass gwClass = new  GWClass("spring.xml");
		Person person = new Person();
		person .setAccessLevel("Admin");
		person .setFirstName("Muhammad");
		person .setId(11);
		person .setLastName("Ali");
		person .setMobile("54654543");
		person .setPassword("123456");
		person .setUsername("m.ali");
		gwClass.addPerson(person);
		List<Person> persons = gwClass.listPerson();
		for(Person  personRet  : persons){
			System.out.println(personRet.getFirstName());
		}
	}
	public static void main(String[] args) {
		new MainBean();		
	}
	
	

}
