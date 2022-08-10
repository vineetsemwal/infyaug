package com.trainingapps.saleapp.productms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.saleapp.productms.dto.AddProductRequest;
import com.trainingapps.saleapp.productms.dto.ProductDetails;
import com.trainingapps.saleapp.productms.exceptions.ProductNotFoundException;
import com.trainingapps.saleapp.productms.service.IProductService;

@RequestMapping("/products")
@RestController
public class ProductRestApi {
	
	@Autowired
	private IProductService service;

	@PostMapping("/add")
	public ProductDetails add(@RequestBody AddProductRequest requestData) {
	 ProductDetails response=	service.add(requestData);
	 return response; 
	}

	@GetMapping("/byid/{id}")
	public ProductDetails fetchById(@PathVariable long id)throws ProductNotFoundException {
		ProductDetails response=service.findProductDetailsById(id);
		return response;
	}
	
}
