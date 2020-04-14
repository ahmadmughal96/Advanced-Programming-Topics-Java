
public class Person 
{
	int id;
	String name;
	String fatherName;
	String mobile_no;
	String organization;
	
	public Person(int id,String name,String fatherName,String mobile_no, String organization)
	{
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.organization = organization;
		this.mobile_no = mobile_no;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getFatherName()
	{
		return fatherName;
	}
	public String Org()
	{
		return organization;
	}
	public String Mobile_No()
	{
		return mobile_no;
	}
}
