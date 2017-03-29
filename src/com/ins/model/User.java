package com.ins.model;

public class User {
	
	String name,emailID,gender,occupation,address;
	int age;
	
	
	public User()
	{
		
	}

	public User(String name, String emailID, String gender, int age, String occupation, String address) {
		super();
		this.name = name;
		this.emailID = emailID;
		this.gender = gender;
		this.age = age;
		this.occupation = occupation;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
	

}
