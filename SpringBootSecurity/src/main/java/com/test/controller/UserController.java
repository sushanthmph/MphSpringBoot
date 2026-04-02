package com.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableMethodSecurity
public class UserController {
	@GetMapping("/")
	public String homePage()
	{
		return "index1";
	}
	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	@GetMapping("/user/read")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public String userPage()
	{
		return "This is simple Spring Security Response for USER and ADMIN";
	}
	@GetMapping("/delete")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminPage()
	{
		return "Only Admin can delete the data";
	}
	@GetMapping("/update")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String updateUsers()
	{
		return "updated user details with ABMIN role";
	}
	@GetMapping("/user/hr/onboard")
	@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_HR','ROLE_EMPLOYEE')")
	public String updateHR()
	{
		return "OnBoard employees with HR role";
	}
	
}
