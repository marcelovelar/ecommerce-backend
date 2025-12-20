package com.ecommerce.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ecommerce.domain.model.Order;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findById(Long id);

    List<Order> findAll();
}
