package com.trainingapps.saleapp.customerms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.trainingapps.saleapp.customerms.dto.CustomerDetails;
import com.trainingapps.saleapp.customerms.dto.ProductDTO;
import com.trainingapps.saleapp.customerms.entity.Customer;

@Component
public class CustomerUtil {
	
	@Value("${product.baseUrl}")
	private String baseProductUrl;
	
	@Autowired
	private RestTemplate restTemplate;


	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails desired = new CustomerDetails();
		desired.setId(customer.getId());
		desired.setCustomerName(customer.getCustomerName());
		Set<Long> products = customer.getBoughtProducts();
		if (products != null) {
			List<ProductDTO> desiredList = fetchProductDetailsList(products);
			desired.setBoughtProducts(desiredList);
		}
		return desired;
	}
	
	public List<ProductDTO>fetchProductDetailsList(Collection<Long>products){
		List<ProductDTO>desiredList=new ArrayList<>();
		for(long productId:products) {
			ProductDTO dto=fetchProductDetailsById(productId);
		    desiredList.add(dto);
		}
		return desiredList;
		
	}
	
	public ProductDTO fetchProductDetailsById(long productId) {
		String url=baseProductUrl+"/products/byid/"+productId;
		ProductDTO response=restTemplate.getForObject(url, ProductDTO.class);
	    return response;
	}
	

}
