package com.trainingapps.saleapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainingapps.saleapp.customerms.exceptions.CustomerNotFoundException;
import com.trainingapps.saleapp.productms.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public String handleProductNotFound(ProductNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleProductNotFound(CustomerNotFoundException e) {
		return e.getMessage();
	}
	
}
