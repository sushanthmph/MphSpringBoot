package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.StudentDao;
import com.test.entity.Student;
import com.test.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao dao;
	@Override
	public Student saveStudent(Student obj) {
		// TODO Auto-generated method stub
		
		return dao.saveStudent(obj);
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return dao.getStudentById(id);
	}

	@Override
	public Student updateStudentById(Student obj) {
		// TODO Auto-generated method stub
		return dao.updateStudentById(obj);
	}

	@Override
	public List<Student> deleteStudentById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteStudentById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return dao.getAllStudents();
	}

}
