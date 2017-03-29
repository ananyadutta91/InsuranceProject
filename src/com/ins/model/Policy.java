package com.ins.model;

public class Policy {
	
	String type,description,status,email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	int cost,max_coverage,pid;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Policy()
	{
		
	}
	public Policy(String type, String description, int cost, int max_coverage) {
		super();
		this.type = type;
		this.description = description;
		this.cost = cost;
		this.max_coverage = max_coverage;
	}
	public Policy(String type, String description, int cost, int max_coverage,int pid) {
		super();
		this.type = type;
		this.description = description;
		this.cost = cost;
		this.max_coverage = max_coverage;
		this.pid = pid;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getMax_coverage() {
		return max_coverage;
	}
	public void setMax_coverage(int max_coverage) {
		this.max_coverage = max_coverage;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	
	

}
