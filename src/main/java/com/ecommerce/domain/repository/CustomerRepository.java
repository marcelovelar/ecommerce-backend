package com.ecommerce.domain.repository;

import java.util.Optional;

import com.ecommerce.domain.model.Customer;

public interface CustomerRepository {
    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

    Optional<Customer> findByEmail(String email);
}
