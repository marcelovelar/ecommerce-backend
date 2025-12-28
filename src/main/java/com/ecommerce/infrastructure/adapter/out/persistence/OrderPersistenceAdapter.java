package com.ecommerce.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.repository.OrderRepository;
import com.ecommerce.infrastructure.adapter.out.persistence.jpa.JpaOrderRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderRepository {

    private final JpaOrderRepository jpaOrderRepository;

    @Override
    public Order save(Order order) {
        return jpaOrderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return jpaOrderRepository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return jpaOrderRepository.findAll();
    }
}
