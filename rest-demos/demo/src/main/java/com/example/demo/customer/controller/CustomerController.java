package com.example.demo.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.dto.AddCustomerRequest;
import com.example.demo.customer.dto.CustomerDetails;
import com.example.demo.customer.service.ICustomerService;

@RequestMapping("/customers")
@RestController
public class CustomerController {
    @Autowired  
	private ICustomerService service;
	
    @ResponseStatus(HttpStatus.CREATED)
    //@RequestMapping(method=RequestMethod.GET,path="/customers/byid/{id}")
    @GetMapping("/byid/{id}")
	public CustomerDetails fetchCustomerById(@PathVariable long id)throws Exception {
		CustomerDetails response=service.findCustomerDetailsById(id);
		return response;
	}
    
    //@RequestMapping(method=RequestMethod.POST,path="/customers/add")
    @PostMapping("/add")
    public CustomerDetails register(@RequestBody AddCustomerRequest request) {
    	CustomerDetails response=service.register(request);
    	return response;
    }
	
}
