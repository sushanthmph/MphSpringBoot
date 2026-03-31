package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Student;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
