package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;
import com.test.repository.RemoteStudentRepository;

@RestController
public class StudentController {
	@Autowired
	private RemoteStudentRepository service;
	@PostMapping("/create")
	public Student createStudent( @RequestBody Student std)
	{
		return service.createStudent(std);
	}
	@GetMapping("/list")
	public List<Student> listAllStudent()
	{
		return service.getAllStudents();
	}
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id)
	{
		return service.getStudentById(id);
	}
	@PutMapping("/update/{id}")
	public Student updateStudentById(@PathVariable int id,@RequestBody Student std)
	{
		return service.updateStudentById(std,id);
	}
	@DeleteMapping("/delete/{id}")
	public List<Student> deleteStudentById(@PathVariable int id)
	{
		return service.deleteStudentById(id);
	}
}
