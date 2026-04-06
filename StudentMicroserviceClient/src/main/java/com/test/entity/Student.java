package com.test.entity;

public class Student {
	private int id;
	private String std_name;
	private String college;
	public Student()
	{
		
	}
	public Student(int id, String std_name, String college) {
		this.id = id;
		this.std_name = std_name;
		this.college = college;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	 
}
