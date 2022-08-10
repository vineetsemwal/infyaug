package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
public class ProductController {

	private Map<String,Product> productsMap=new HashMap<>();
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product requestData){
		productsMap.put(requestData.getName(), requestData);
		return requestData;
	}
	
	@GetMapping("/byname/{name}")
	public Product getProduct(@PathVariable String name) {
		Product product=productsMap.get(name);
	    return product; 
	 }
	
	@PutMapping("/changeprice/byname")
	public Product updatePrice(@RequestBody Product requestData) {
		Product found=productsMap.get(requestData.getName());
	    found.setPrice(requestData.getPrice());
	    return found;
	}
	
	
}
