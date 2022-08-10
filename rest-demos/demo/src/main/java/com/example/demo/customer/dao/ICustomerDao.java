package com.example.demo.customer.dao;

import java.util.Optional;

import com.example.demo.customer.entity.Customer;

public interface ICustomerDao {

	Customer add(Customer customer);
	
	Optional<Customer> findById(long id);
	

	
}
