package com.ecommerce.infrastructure.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.domain.model.Customer;
import com.ecommerce.domain.repository.CustomerRepository;

public interface JpaCustomerRepository extends JpaRepository<Customer, Long>, CustomerRepository {
}
