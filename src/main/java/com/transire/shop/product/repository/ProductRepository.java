package com.transire.shop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transire.shop.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
