package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.client.StudentClient;
import com.test.entity.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentClient client;
	@GetMapping("/list")
	public List<Student> listAllStudent()
	{
		return client.getAllStudents();
	}
}
