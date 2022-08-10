package com.trainingapps.saleapp.customerms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainingapps.saleapp.customerms.dto.AddCustomerRequest;
import com.trainingapps.saleapp.customerms.dto.BuyProductRequest;
import com.trainingapps.saleapp.customerms.dto.CustomerDetails;
import com.trainingapps.saleapp.customerms.entity.Customer;
import com.trainingapps.saleapp.customerms.exceptions.CustomerNotFoundException;
import com.trainingapps.saleapp.customerms.repository.ICustomerRepository;
import com.trainingapps.saleapp.customerms.util.CustomerUtil;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;

	
	@Autowired
	private CustomerUtil customerUtil;

	@Override
	public CustomerDetails register(@Valid AddCustomerRequest addRequest) {
		Customer customer = new Customer();
		customer.setCustomerName(addRequest.getName());
		customer = customerRepo.save(customer);
		CustomerDetails desired = customerUtil.toDetails(customer);
		return desired;
	}

	Customer findById(long id) throws CustomerNotFoundException {
		Optional<Customer> optional = customerRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new CustomerNotFoundException("customer not found for id=" + id);
	}

	@Override
	public CustomerDetails findDetailsById(long id) throws CustomerNotFoundException {
		Customer customer = findById(id);
		CustomerDetails desired = customerUtil.toDetails(customer);
		return desired;
	}

	@Override
	public CustomerDetails buyProduct(BuyProductRequest requestData)
			throws CustomerNotFoundException{
		Customer customer=findById(requestData.getCustomerId());
		Set<Long>products=customer.getBoughtProducts();
		if(products==null) {
			products=new HashSet<>();
			customer.setBoughtProducts(products);
		}
		products.add(requestData.getProductId());
		customerRepo.save(customer);
		CustomerDetails desired = customerUtil.toDetails(customer);
		return desired;
	}

}
