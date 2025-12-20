package com.ecommerce.domain.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.repository.ProductRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {
}
