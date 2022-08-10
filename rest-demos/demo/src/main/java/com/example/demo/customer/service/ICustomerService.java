package com.example.demo.customer.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.example.demo.customer.dto.AddCustomerRequest;
import com.example.demo.customer.dto.CustomerDetails;
import com.example.demo.customer.exceptions.CustomerNotFoundException;

@Validated
public interface ICustomerService {

CustomerDetails	register(@Valid AddCustomerRequest request);

CustomerDetails findCustomerDetailsById(@Min(1)long id)
		throws  CustomerNotFoundException;
	
}
