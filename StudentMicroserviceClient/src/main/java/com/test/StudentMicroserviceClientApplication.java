package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.test.repository.RemoteStudentRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentMicroserviceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMicroserviceClientApplication.class, args);
	}
	@Bean
	@LoadBalanced
	protected RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	@Bean
	public RemoteStudentRepository remoteStudentRepository()
	{
		return new RemoteStudentRepository();
	}

}
