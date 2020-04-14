//Ahmad Amjad Mughal
//121672
//BSCS-6C
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public Main() 
	{
		Person person = new Person();
		Scanner scan = new Scanner(System.in);
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		applicationContext.registerShutdownHook(); 
		PersonDao hibernateDaoImp = (PersonDao) applicationContext.getBean("hibernateDaoImp");
		
		System.out.println("Enter your Person's id: ");
		int id = scan.nextInt();
		System.out.println("\nEnter your Person's name: ");
		String name = scan.next();
		
		System.out.println("\nEnter your Person's fatherName: ");		
		String father_name = scan.next();
		
		System.out.println("\nEnter your Person's Organization: ");
		String organize = scan.next();
		
		System.out.println("\nEnter your Person's mobile_no: ");
		String mobile = scan.next();
		
		System.out.println("\nEnter your Person's user_name: ");	
		String user = scan.next();
		
		System.out.println("\nEnter your Person's password: ");
		String pass = scan.next();
		
		person.setId(id);
		person.setName(name);
		person.setFatherName(father_name);
		person.setOrganization(organize);
		person.setMobile(mobile);
		person.setUserName(user);
		person.setPassword(pass);
		
		
		hibernateDaoImp.addPerson(person);
		hibernateDaoImp.deletePerson(195143);
		hibernateDaoImp.getPerson(121672);
		applicationContext.close();
	}

	public static void main(String[] args) {
		new Main();
	}
}