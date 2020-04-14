//Ahmad Amjad Mughal
//121672
//BSCS-6C
//Assignment 2
package com.mughal.Assignment_2;

//Utilities and Dependencies 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person 
{
	
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "mobile_no")
	private String mobile_no;
	@Column(name = "user_name")
	@Id 
	private String user_name;
	@Column(name = "password")
	private String password;
	@Column(name = "acess_level")
	private String acess_level;


public Person() {}
public Person(String user)
{
	setUser(user_name);
}
public Person(String first_name, String last_name, String mobile_no, String user_name, String password, String acess_level) {
	setFirst_Name(first_name);
	setLast_Name(last_name);
	setMobile(mobile_no);
	setUser(user_name);
	setPassword(password);
	setAcess_Level(acess_level);
}

//getters setters
public String getFirst_Name() {
	return first_name;
}

public String getLast_Name() {
	return last_name;
}

public String getMobile() {
	return mobile_no;
}

public String getUser() {
	return user_name;
}

public String getPassword() {
	return password;
}

public String getAcess_Level()
{
	return acess_level;
}

public void setFirst_Name(String first_name) {
	this.first_name = first_name;
}

public void setLast_Name(String last_name) {
	this.last_name = last_name;
}

public void setMobile(String mobile_no) {
	this.mobile_no = mobile_no;
}

public void setUser(String user_name) {
	this.user_name = user_name;
}

public void setPassword(String password) {
	this.password = password;
}

public void setAcess_Level(String acess_level){
	this.acess_level = acess_level;
}
}