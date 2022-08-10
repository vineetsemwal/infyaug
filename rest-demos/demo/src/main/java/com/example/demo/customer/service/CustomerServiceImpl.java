package com.example.demo.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.dao.ICustomerDao;
import com.example.demo.customer.dto.AddCustomerRequest;
import com.example.demo.customer.dto.CustomerDetails;
import com.example.demo.customer.entity.Customer;
import com.example.demo.customer.exceptions.CustomerNotFoundException;
import com.example.demo.customer.util.CustomerUtil;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;

	@Autowired
	private CustomerUtil customerUtil;

	private long generatedId;

	long generateId() {
		return ++generatedId;
	}

	@Override
	public CustomerDetails register(AddCustomerRequest request) {
		long id = generateId();
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(request.getName());
		dao.add(customer);
		CustomerDetails desired = customerUtil.toDetails(customer);
		return desired;
	}

	@Override
	public CustomerDetails findCustomerDetailsById(long id)
			throws  CustomerNotFoundException{
		Optional<Customer> optional = dao.findById(id);
		if (optional.isEmpty()) {
            throw new CustomerNotFoundException("custtomer not found for id="+id);
		}
		Customer customer = optional.get();
		CustomerDetails desired = customerUtil.toDetails(customer);
		return desired;
	}

}
