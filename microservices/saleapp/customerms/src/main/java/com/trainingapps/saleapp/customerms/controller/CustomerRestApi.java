package com.trainingapps.saleapp.customerms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.saleapp.customerms.dto.AddCustomerRequest;
import com.trainingapps.saleapp.customerms.dto.BuyProductRequest;
import com.trainingapps.saleapp.customerms.dto.CustomerDetails;
import com.trainingapps.saleapp.customerms.exceptions.CustomerNotFoundException;
import com.trainingapps.saleapp.customerms.service.ICustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerRestApi {

	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/register")
	public CustomerDetails register(@RequestBody AddCustomerRequest registerRequest) {
		return customerService.register(registerRequest);
	}
	
	@GetMapping("/by/id/{id}")
	public CustomerDetails getCustomerById(@PathVariable long id)
			throws CustomerNotFoundException {
		return customerService.findDetailsById(id);
	}
	
	@PutMapping("/buy")
	public CustomerDetails buyProduct(@RequestBody BuyProductRequest request)
			throws CustomerNotFoundException{
		return customerService.buyProduct(request);
	}
	
}
