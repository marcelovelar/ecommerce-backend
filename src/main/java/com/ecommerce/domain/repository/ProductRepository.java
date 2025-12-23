package com.ecommerce.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.domain.model.Product;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    List<Product> findByCategoryId(Long categoryId);

    void deleteById(Long id);
}
