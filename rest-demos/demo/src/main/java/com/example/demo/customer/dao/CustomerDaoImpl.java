package com.example.demo.customer.dao;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.customer.entity.Customer;

public class CustomerDaoImpl implements ICustomerDao{

	private Map<Long, Customer>store=new HashMap<>();
	
		
	@Override
	public Customer add(Customer customer) {
		store.put(customer.getId(), customer);
		return customer;
	}

	@Override
	public Customer findById(long id) {
		Customer customer=store.get(id);
		return customer;
	}
	

}
