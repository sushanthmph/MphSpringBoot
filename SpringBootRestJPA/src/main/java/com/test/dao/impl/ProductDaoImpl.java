package com.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.repository.ProductRepository;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private ProductRepository repository;
	@Override
	public Product saveProduct(Product obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Product updateProductById(Product obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public List<Product> deleteProductById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Product> getProductsByName(String name) {
		// TODO Auto-generated method stub
		return repository.getProductsByName(name);
	}

	@Override
	public List<Product> getProductByQuantity(int qnty) {
		// TODO Auto-generated method stub
		return repository.getProductByQuantity(qnty);
	}

	@Override
	public List<Product> getProductByNameQP(String name) {
		// TODO Auto-generated method stub
		return repository.getProductByNameQP(name);
	}

	@Override
	public List<Product> getProductsByQuantityQP(int qnty) {
		// TODO Auto-generated method stub
		return repository.getProductsByQuantityQP(qnty);
	}

	@Override
	public List<Product> getAllProductsByNameASC() {
		// TODO Auto-generated method stub
		return repository.getAllProductsByNameASC();
	}

}
