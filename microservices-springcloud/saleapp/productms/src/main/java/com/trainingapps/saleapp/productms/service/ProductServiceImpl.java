package com.trainingapps.saleapp.productms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainingapps.saleapp.productms.dto.AddProductRequest;
import com.trainingapps.saleapp.productms.dto.ProductDetails;
import com.trainingapps.saleapp.productms.entity.Product;
import com.trainingapps.saleapp.productms.exceptions.ProductNotFoundException;
import com.trainingapps.saleapp.productms.repository.IProductRepository;
import com.trainingapps.saleapp.productms.util.ProductUtil;

@Transactional
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository repository;
	@Autowired
	private ProductUtil productUtil;

	@Override
	public ProductDetails add(AddProductRequest requestData) {
		Product product = new Product();
		product.setProductName(requestData.getProductName());
		product.setPrice(requestData.getPrice());
		product = repository.save(product);
		ProductDetails desired = productUtil.toDetails(product);
		return desired;
	}

	@Override
	public Product findProductById(long id) throws ProductNotFoundException{		
	Optional<Product> optional = repository.findById(id);
	if (optional.isPresent()) {
		Product product = optional.get();
				return product;
	}
	throw new ProductNotFoundException("product not found by id="+id);
	}

	
	@Override
	public ProductDetails findProductDetailsById(long id) throws ProductNotFoundException{
		Product product=findProductById(id);
		ProductDetails desired = productUtil.toDetails(product);
		return desired;
	}

}
