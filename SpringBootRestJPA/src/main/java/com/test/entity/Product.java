
package com.test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "p_id")
	private int id;
	@Column(name="p_name")
	private String name;
	@Column(name="description")
	private String descp;
	@Column(name="quantity")
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
