package com.test.model;

public class Customer {
	private String id;
	private String c_name;
	private String c_email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", c_name=" + c_name + ", c_email=" + c_email + "]";
	}
	

}
