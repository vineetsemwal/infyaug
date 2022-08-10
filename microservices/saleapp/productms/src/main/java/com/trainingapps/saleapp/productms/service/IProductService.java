package com.trainingapps.saleapp.productms.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.saleapp.productms.dto.AddProductRequest;
import com.trainingapps.saleapp.productms.dto.ProductDetails;
import com.trainingapps.saleapp.productms.entity.Product;
import com.trainingapps.saleapp.productms.exceptions.ProductNotFoundException;

@Validated
public interface IProductService {

	ProductDetails add(@Valid AddProductRequest requestData);

	Product findProductById(@Min(1) long id) throws ProductNotFoundException;

	ProductDetails findProductDetailsById(@Min(1) long id) throws ProductNotFoundException;

}
