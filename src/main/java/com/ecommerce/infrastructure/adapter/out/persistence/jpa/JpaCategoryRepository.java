package com.ecommerce.infrastructure.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.Category;
import com.ecommerce.domain.repository.CategoryRepository;

public interface JpaCategoryRepository extends JpaRepository<Category, Long>, CategoryRepository {
}
