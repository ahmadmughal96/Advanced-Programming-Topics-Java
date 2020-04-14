//Ahmad Amjad Mughal
//121672
//BSCS-6C

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="person")
public class Person {
	@Id
	@Column( name = "id")
	private int id;
	@Column( name = "name")
	private String name;
	@Column( name = "father_name")
	private String father_name;
	@Column( name = "organization")
	private String organization;
	@Column( name = "mobile_no")
	private String mobile_no;
	@Column( name = "user_name")
	private String user_name;
	@Column( name = "password")
	private String password;
	
	public Person(){
		
	}
	
	public Person(int id, String name, String fatherName, String organization, String mobile, String userName, String password){
		this.id = id;
		this.name = name;
		this.father_name = fatherName;
		this.organization = organization;
		this.mobile_no = mobile;
		this.user_name = userName;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getFatherName() {
		return father_name;
	}
	public String getOrganization() {
		return organization;
	}
	public String getMobile() {
		return mobile_no;
	}
	public String getUserName() {
		return user_name;
	}
	public String getPassword() {
		return password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFatherName(String fatherName) {
		this.father_name = fatherName;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public void setMobile(String mobile) {
		this.mobile_no = mobile;
	}
	public void setUserName(String userName) {
		this.user_name = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

