package com.test.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productdao;
	@Override
	public Product saveProduct(Product obj) {
		// TODO Auto-generated method stub
		return productdao.saveProduct(obj);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productdao.getProductById(id);
	}

	@Override
	public Product updateProductById(Product obj) {
		// TODO Auto-generated method stub
		return productdao.updateProductById(obj);
	}

	@Override
	public List<Product> deleteProductById(int id) {
		// TODO Auto-generated method stub
		return productdao.deleteProductById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productdao.getAllProduct();
	}

	@Override
	public List<Product> getProductsByName(String name) {
		// TODO Auto-generated method stub
		return productdao.getProductsByName(name);
	}

	@Override
	public List<Product> getProductByQuantity(int qnty) {
		// TODO Auto-generated method stub
		return productdao.getProductByQuantity(qnty);
	}

	@Override
	public List<Product> getProductByNameQP(String name) {
		// TODO Auto-generated method stub
		return productdao.getProductByNameQP(name);
	}

	@Override
	public List<Product> getProductsByQuantityQP(int qnty) {
		// TODO Auto-generated method stub
		return productdao.getProductsByQuantityQP(qnty);
	}

	@Override
	public List<Product> getAllProductsByNameASC() {
		// TODO Auto-generated method stub
		return productdao.getAllProductsByNameASC();
	}

}
