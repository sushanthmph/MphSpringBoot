package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class Service2Controller {
	
	@GetMapping("/upi")
	public String upiPayments() {
		return "Spring Cloud Service2 UPI payments";
	}
}
