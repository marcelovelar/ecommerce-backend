package com.ecommerce.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.application.dto.ProductDTO;
import com.ecommerce.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    List<Product> findByCategoryId(Long categoryId);

    void deleteById(Long id);

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
