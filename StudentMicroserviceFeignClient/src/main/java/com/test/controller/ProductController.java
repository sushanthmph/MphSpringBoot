package com.test.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.client.ProductClient;
import com.test.entity.Product;


@RestController
@RequestMapping("/product/v1/api")

public class ProductController {
	@Autowired
	private ProductClient service;
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>> listAllProducts(){
		List<Product> list = service.getAllProducts();
		if(!list.isEmpty()) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	

}
