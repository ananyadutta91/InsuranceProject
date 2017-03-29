package com.ins.model;

public class Message {
	public String message,date,email,role;

	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

	public Message(String message, String from, String date, String role) {
		super();
		this.message = message;
		
		this.date = date;
		this.email = email;
		this.role = role;
	}



	public Message() {
		// TODO Auto-generated constructor stub
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "Message [message=" + message + ", date=" + date + ", email=" + email + ", role=" + role + "]";
	}
	
	

}
