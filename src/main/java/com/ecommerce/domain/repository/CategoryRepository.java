package com.ecommerce.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.domain.model.Category;

public interface CategoryRepository {
    Category save(Category category);

    Optional<Category> findById(Long id);

    List<Category> findAll();

    void deleteById(Long id);
}
