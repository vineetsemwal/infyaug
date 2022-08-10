package com.trainingapps.saleapp.customerms.util;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingapps.saleapp.customerms.dto.CustomerDetails;
import com.trainingapps.saleapp.customerms.entity.Customer;
import com.trainingapps.saleapp.productms.dto.ProductDetails;
import com.trainingapps.saleapp.productms.entity.Product;
import com.trainingapps.saleapp.productms.util.ProductUtil;

@Component
public class CustomerUtil {

	@Autowired
	private ProductUtil productUtil;

	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails desired = new CustomerDetails();
		desired.setId(customer.getId());
		desired.setCustomerName(customer.getCustomerName());
		Set<Product> products = customer.getBoughtProducts();
		if (products != null) {
			List<ProductDetails> desiredList = productUtil.toDetailsList(products);
			desired.setBoughtProducts(desiredList);
		}
		return desired;
	}

}
