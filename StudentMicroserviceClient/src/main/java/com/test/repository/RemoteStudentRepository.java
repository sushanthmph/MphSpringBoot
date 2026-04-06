package com.test.repository;

import java.util.ArrayList;
import java.util.List;

import com.test.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteStudentRepository {
	public static String student_url="http://STUDENTMICROSERVICE";
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Student> getAllStudents()
	{
		List<Student> list = restTemplate.getForObject(student_url+"/list", new ArrayList<Student>().getClass());
		return list;
	}
	public Student getStudentById(int id)
	{
		Student obj = restTemplate.getForObject(student_url+"/{id}", Student.class,id);
		return obj;
	}
	public Student createStudent(Student obj)
	{
		obj = restTemplate.postForObject(student_url+"/create", obj, Student.class);
		return obj;
	}
	public Student updateStudentById(Student obj,int id)
	{
		obj.setId(id);
		restTemplate.put(student_url+"/update/{id}", obj,Student.class,id);
		return obj;
	}
	public List<Student> deleteStudentById(int id)
	{
		restTemplate.delete(student_url+"/delete/{id}", Student.class,id);
		List<Student> list = restTemplate.getForObject(student_url+"/url",new ArrayList<Student>().getClass() );
		return list;
	}
	
}
