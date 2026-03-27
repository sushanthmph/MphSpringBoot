package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("${student.id}")
	private int id;
	@Value("${student.name}")
	private String name;
	@Value("${student.college}")
	private String college;
	@Value("${student.city}")
	private String city;
	@Value("${student.feedback}")
	private String feedback;
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
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", city=" + city + ", feedback="
				+ feedback + "]";
	}
	
	
}
