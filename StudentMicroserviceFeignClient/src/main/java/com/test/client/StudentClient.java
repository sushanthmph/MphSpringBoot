package com.test.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.test.entity.Student;

@FeignClient(name="StudentMicroservice",
url="http://localhost:2222")
public interface StudentClient {
	@GetMapping("/list")
	public List<Student> getAllStudents();
}
