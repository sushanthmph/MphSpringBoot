package com.test.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Product;
import com.test.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/product/v1/api")
@Tag(name = "PRODUCT CRUD OPERATIONS")
public class ProductController {
	@Autowired
	private ProductService service;
	@PostMapping("/create/")
	public ResponseEntity<Product> createProduct(@RequestBody Product obj) {
		Product pr = service.saveProduct(obj);
		if(pr != null) {
			return new ResponseEntity<Product>(pr,HttpStatus.CREATED);
			
		}
		else {
			return new ResponseEntity<Product>(pr,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/list")
	public ResponseEntity<List<Product>> listAllProducts(){
		List<Product> list = service.getAllProduct();
		if(!list.isEmpty()) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Product pr = service.getProductById(id);
		if(pr != null) {
			return new ResponseEntity<>(pr,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(pr,HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable int id, @RequestBody Product obj){
		obj.setId(id);
		Product pr = service.updateProductById(obj);
		if(pr != null) {
			return new ResponseEntity<>(pr,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(pr,HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Product>> deleteProductById(@PathVariable int id){
		List<Product> list = service.deleteProductById(id);
		if(!list.isEmpty()) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/list/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
		List<Product> list = service.getProductsByName(name);
		if(!list.isEmpty()) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/order")
	public ResponseEntity<List<Product>> getAllProductsByOrderASC(){
		List<Product> list = service.getAllProductsByNameASC();
		if(!list.isEmpty()) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
}
