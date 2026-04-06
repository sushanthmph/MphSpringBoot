package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudentMicroserviceFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMicroserviceFeignClientApplication.class, args);
	}

}
