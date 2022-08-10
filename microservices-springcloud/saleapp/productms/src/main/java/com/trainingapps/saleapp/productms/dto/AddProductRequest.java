package com.trainingapps.saleapp.productms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Request DTO class
 * 
 * @author vineet
 *
 */
public class AddProductRequest {
	
	@Length(min=2,max=20)
	@NotBlank
	private String productName;
	
	@Min(0)
	private double price;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
