import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Person" )
public class Person 
{
	@Id
	private int id;
	private String name;
	private String father_name;
	private String organization;
	private String mobile_no;
	private String user_name;
	private String password;
		
	public Person() {}
		
	public Person(int id, String name, String father_name, String organization, String mobile_no, String user, String password) {
		setId(id);
		setName(name);
		setFathername(father_name);
		setOrganization(organization);
		setMobile(mobile_no);
		setUser(user);
		setPassword(password);
		}
		
		//getters setters
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public String getFathername() {
			return father_name;
		}
		
		public String getOrganization() {
			return organization;
		}
		
		public String getMobile() {
			return mobile_no;
		}
		public String getUser(){
			return user_name;
		}	
		public String getPassword(){
			return password;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setFathername(String fathername) {
			this.father_name = fathername;
		}
		
		public void setOrganization(String organization) {
			this.organization = organization;
		}
		
		public void setMobile(String mobile) {
			this.mobile_no = mobile;
		}
		public void setUser(String user){
			this.user_name = user;
		}
		public void setPassword(String password){
			this.password = password;
		}
		public String toString()
		{
		System.out.println(id+"\t"+name+"\t"+father_name+"\t"+organization+"\t"+mobile_no+"\t"+user_name+"\t"+password);
		return id+"\t"+name+"\t"+father_name+"\t"+organization+"\t"+mobile_no+"\t"+user_name+"\t"+password;
		}

}
