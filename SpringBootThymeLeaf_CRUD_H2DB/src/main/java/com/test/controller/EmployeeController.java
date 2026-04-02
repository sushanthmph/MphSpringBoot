package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employee/")
public class EmployeeController {
	private final EmployeeRepository employeeRepository;
	@Autowired
	public EmployeeController(EmployeeRepository employeeRepository)
	{
		this.employeeRepository=employeeRepository;
	}
	@GetMapping("signup")
	public String showSignUpForm(Employee emp)
	{
		return "add-employee";
	}
	@GetMapping("list")
	public String showUpdateForm(Model model)
	{
		model.addAttribute("employee",employeeRepository.findAll());
		return "index";
	}
	@PostMapping("add")
	public String addEmployee(@Valid Employee employee, BindingResult result , Model model)
	{
		if(result.hasErrors())
		{
			return "add-employee";
		}
		employeeRepository.save(employee);
		return "redirect:list";
		
	}
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable long id,Model model)
	{
		Employee employee = employeeRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("invalid Employee id : "+id));
		model.addAttribute("employee",employeeRepository.findAll());
		return "update-employee";
	}
	@PostMapping("update/{id}")
	public String updateEmployee(@PathVariable long id,
	@Valid Employee employee,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			employee.setId(id);
			return "update-employee";
		}
		employeeRepository.save(employee);
		model.addAttribute("employees",employeeRepository.findAll());
		return "index";
				
	}
	@GetMapping("delete/{id}")
	public String deleteEmployee(@PathVariable long id,Model model)
	{
		Employee employee = employeeRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("invalid Employee id : "+id));
		employeeRepository.deleteById(id);
		model.addAttribute("employee",employeeRepository.findAll());
		return "index";
	}
	

}
