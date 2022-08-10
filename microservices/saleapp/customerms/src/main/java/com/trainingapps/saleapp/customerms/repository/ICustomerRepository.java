package com.trainingapps.saleapp.customerms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingapps.saleapp.customerms.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
