package com.example.demo.customer.dao;

import com.example.demo.customer.entity.Customer;

public interface ICustomerDao {

	Customer add(Customer customer);
	
	Customer findById(long id);
	

	
}
