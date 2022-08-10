package com.example.demo.customer.service;

import com.example.demo.customer.dto.AddCustomerRequest;
import com.example.demo.customer.dto.CustomerDetails;

public interface ICustomerService {

CustomerDetails	register(AddCustomerRequest request);

CustomerDetails findCustomerDetailsById(long id);
	
}
