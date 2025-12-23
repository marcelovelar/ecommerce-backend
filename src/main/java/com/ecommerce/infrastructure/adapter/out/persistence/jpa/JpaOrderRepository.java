package com.ecommerce.infrastructure.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.repository.OrderRepository;

public interface JpaOrderRepository extends JpaRepository<Order, Long>, OrderRepository {
}
