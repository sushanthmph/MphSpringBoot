package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.MyService;

@RestController
public class TestController {
	private final MyService myService;
	public TestController(MyService myService)
	{
		this.myService=myService;
	}
	@GetMapping("/test")
	public String test()
	{
		return myService.message();
	}
}
