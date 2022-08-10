package com.example.demo.customer.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.customer.entity.Customer;


@Repository
public class CustomerDaoImpl implements ICustomerDao{

	private Map<Long, Customer>store=new HashMap<>();
	
		
	@Override
	public Customer add(Customer customer) {
		store.put(customer.getId(), customer);
		return customer;
	}

	@Override
	public Optional<Customer> findById(long id) {
		Customer customer=store.get(id);
		if(customer==null) {
		Optional<Customer> optional=Optional.empty();
	    return optional; 
		}
		Optional<Customer>optional=Optional.of(customer);
		return optional;
		
		
	}
	

}
