package com.test.dao;

import java.util.List;

import com.test.entity.Student;

public interface StudentDao {
	
	public Student saveStudent(Student obj);
	public Student getStudentById(int id);
	public Student updateStudentById(Student obj);
	public List<Student> deleteStudentById(int id);
	public List<Student> getAllStudents();
	
}
