package com.ahmad.Lab_07;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
	@Id
	private int id;
	private String name;
	private String fathername;
	private String organization;
	private String mobile;
	
	public Person() {}
	
	public Person(int id, String name, String fathername, String organization, String mobile) {
		setId(id);
		setName(name);
		setFathername(fathername);
		setOrganization(organization);
		setMobile(mobile);
	}
	
	//getters setters
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFathername() {
		return fathername;
	}
	
	public String getOrganization() {
		return organization;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
