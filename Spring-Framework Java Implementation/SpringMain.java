import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringMain 
{
	public static void main(String args[])
	{
	Person person = new Person(123,"NULL","NULL","NULL","NULL","aaas","1212");
	AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
	applicationContext.registerShutdownHook();
	DAO hibernateDao = (DAO)applicationContext.getBean("DAO"
			+ "");
	hibernateDao.getAllPersons();
	applicationContext.close();
	}
}
