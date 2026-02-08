package com.ecommerce.application.mapper;

import com.ecommerce.application.dto.CustomerDTO;
import com.ecommerce.domain.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());

        if (customer.getRoles() != null) {
            dto.setRoles(customer.getRoles().stream()
                    .map(role -> role.getRoleName())
                    .collect(Collectors.toSet()));
        }

        return dto;
    }
}
