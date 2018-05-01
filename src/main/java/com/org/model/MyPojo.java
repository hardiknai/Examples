package com.org.model;

public class MyPojo {

	private String name;
	private String discription;
	
	public MyPojo(String name, String discription) {
		this.name = name;
		this.discription = discription;
	}
	
	public MyPojo() {
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "MyPojo [name=" + name + ", description=" + discription + "]";
	}
	
}
