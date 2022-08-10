package com.trainingapps.saleapp.productms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trainingapps.saleapp.productms.dto.ProductDetails;
import com.trainingapps.saleapp.productms.entity.Product;

@Component
public class ProductUtil {

	public ProductDetails toDetails(Product product) {
		ProductDetails desired=new ProductDetails();
		desired.setId(product.getId());
		desired.setProductName(product.getProductName());
		desired.setPrice(product.getPrice());
		return desired;
	}
	
	public List<ProductDetails> toDetailsList(Collection<Product> products) {
		List<ProductDetails>desiredList=new ArrayList<>() ;
		for(Product product:products) {
			ProductDetails desired=toDetails(product);
		   desiredList.add(desired);  
		}
		return desiredList;
	}
	
}
