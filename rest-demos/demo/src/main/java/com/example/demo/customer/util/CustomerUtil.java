package com.example.demo.customer.util;

import org.springframework.stereotype.Component;

import com.example.demo.customer.dto.CustomerDetails;
import com.example.demo.customer.entity.Customer;


@Component
public class CustomerUtil {

	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails desired=new CustomerDetails();
	    desired.setId(customer.getId());
	    desired.setName(customer.getName());
	    return desired;
	}
	
	
}
