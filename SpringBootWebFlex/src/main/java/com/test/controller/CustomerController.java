package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Customer;
import com.test.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository repository;
	
	@PostMapping("/create")
	public Mono<Customer> createCustomer(@RequestBody Customer cst){
		return repository.save(cst);
	}
	@GetMapping("/list")
	public Flux<Customer> listAllCustomers(){
		return repository.findAll();
	}
}
