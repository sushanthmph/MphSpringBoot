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
import com.test.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	@PostMapping("/create")
	public Student createStudent( @RequestBody Student std)
	{
		return service.addStudent(std);
	}
	@GetMapping("/list")
	public List<Student> listAllStudent()
	{
		return service.getAllStudent();
	}
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id)
	{
		return service.getStudentByid(id);
	}
	@PutMapping("/update/{id}")
	public Student updateStudentById(@PathVariable int id,@RequestBody Student std)
	{
		std.setId(id);
		return service.updateStudentById(std);
	}
	@DeleteMapping("/delete/{id}")
	public List<Student> deleteStudentById(@PathVariable int id)
	{
		return service.deleteStudentById(id);
	}
}
