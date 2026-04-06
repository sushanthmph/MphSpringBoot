
package com.test.entity;



public class Product {

	
	private int id;
	
	private String name;
	
	private String descp;
	
	private int qnty;
	public Product() {}
	
	public Product(int id, String name, String descp, int qnty) {
		this.id = id;
		this.name = name;
		this.descp = descp;
		this.qnty = qnty;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public int getQnty() {
		return qnty;
	}
	public void setQnty(int qnty) {
		this.qnty = qnty;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", descp=" + descp + ", qnty=" + qnty + "]";
	}
	
	

}
