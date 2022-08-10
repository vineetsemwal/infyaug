package com.trainingapps.saleapp.customerms.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.saleapp.customerms.dto.AddCustomerRequest;
import com.trainingapps.saleapp.customerms.dto.BuyProductRequest;
import com.trainingapps.saleapp.customerms.dto.CustomerDetails;
import com.trainingapps.saleapp.customerms.exceptions.CustomerNotFoundException;


@Validated
public interface ICustomerService {

	CustomerDetails register(@Valid AddCustomerRequest addRequest);
	
	CustomerDetails findDetailsById(@Min(1)long id) throws CustomerNotFoundException;
	
	CustomerDetails buyProduct(@Valid BuyProductRequest requestData)throws CustomerNotFoundException;
	
	
	
}
