package com.trainingapps.saleapp.customerms.dto;

import java.util.List;
import java.util.Set;

import com.trainingapps.saleapp.productms.dto.ProductDetails;
import com.trainingapps.saleapp.productms.entity.Product;

public class CustomerDetails {
	private Long id;

	private String customerName;

	private List<ProductDetails> boughtProducts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<ProductDetails> getBoughtProducts() {
		return boughtProducts;
	}

	public void setBoughtProducts(List<ProductDetails> boughtProducts) {
		this.boughtProducts = boughtProducts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDetails other = (CustomerDetails) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
