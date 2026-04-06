package com.test.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.entity.Product;

@FeignClient(name="SpringBootRestJPA",

url="http://localhost:7798/product/v1/api")
public interface ProductClient {
	@GetMapping("/list")
	public List<Product> getAllProducts();
	
}
