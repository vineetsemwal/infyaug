package com.trainingapps.saleapp.productms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingapps.saleapp.productms.entity.Product;

public interface IProductRepository extends JpaRepository<Product,Long>{

}
