import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler 
{	
	
	Person person = new Person(121672, "Ahmad","Amjad","NUST","0324-6191134");
public DBHandler() throws SQLException
{
	try
	{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Identity","localhost","");
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from Person");  
	}
	catch(ClassNotFoundException e1)
	{
		e1.printStackTrace();
	}
}
	public void Save(Person person)
	{
		
	}
	public void Update(Person person)
	{
		Statement statement = con.createStatement();
	}
	public void Delete(int personId)
	{
		person.id = 121672;
		personId = person.id;
	}
	public void get(int personId)
	{
		person.id = 121672;
		personId = person.id;
	}
	
}
