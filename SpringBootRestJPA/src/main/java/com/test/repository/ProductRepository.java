package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Product;
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.name=?1")
	List<Product> getProductsByName(String name);
	@Query("select p from Product p where p.qnty=?1")
	List<Product> getProductByQuantity(int qnty);
	@Query("select p from Product p where p.name= :name")
	List<Product> getProductByNameQP(@Param("name")String name);
	@Query("select p from Product p where p.qnty= :qnty")
	List<Product> getProductsByQuantityQP(@Param("qnty")int qnty);
	@Query("select p from Product p order by p.name ASC")
	List<Product> getAllProductsByNameASC();
	

}
