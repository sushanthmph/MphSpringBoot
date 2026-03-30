package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.model.Customer;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class CustomerController {
	@GetMapping("/Customerform")
	public String userLoginForm()
	{
		return "login";
	}
	@GetMapping("/submit")
	public String userSubmitForm(HttpServletRequest request,Customer user, Model model)
	{
		String usr = request.getParameter("customer");
		String pas = request.getParameter("name");
		String email =request.getParameter("mail");
		user.setId(usr);
		user.setC_name(pas);
		user.setC_email(email);
		model.addAttribute("data",user);
		if(usr.equals(user.getId()) && pas.equals(user.getC_name()) && email.equals(user.getC_email()))
		{
			return "success";
			
		}
		else
		{
			return "login";
		}
	}

}
