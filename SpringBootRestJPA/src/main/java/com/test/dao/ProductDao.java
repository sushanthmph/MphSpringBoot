package com.test.dao;

import java.util.List;


import com.test.entity.Product;

public interface ProductDao {
	Product saveProduct(Product obj);
	Product getProductById(int id);
	Product updateProductById(Product obj);
	List<Product> deleteProductById(int id);
	List<Product> getAllProduct();
	List<Product> getProductsByName(String name);
	List<Product> getProductByQuantity(int qnty);
	List<Product> getProductByNameQP(String name);
	List<Product> getProductsByQuantityQP(int qnty);
	List<Product> getAllProductsByNameASC();

}
