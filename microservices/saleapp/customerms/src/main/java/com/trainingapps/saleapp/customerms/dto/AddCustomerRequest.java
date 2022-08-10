package com.trainingapps.saleapp.customerms.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class AddCustomerRequest {

	@Length(min=3,max=20)
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
