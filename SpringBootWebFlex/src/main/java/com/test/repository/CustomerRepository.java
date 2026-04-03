package com.test.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Customer;
@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long>{

}
