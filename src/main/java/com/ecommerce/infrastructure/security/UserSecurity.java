package com.ecommerce.infrastructure.security;

import com.ecommerce.domain.model.Customer;
import com.ecommerce.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("userSecurity")
@RequiredArgsConstructor
public class UserSecurity {

    private final CustomerRepository customerRepository;

    public boolean isCurrentUser(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        String email = authentication.getName();

        return customerRepository.findByEmail(email)
                .map(customer -> customer.getId().equals(id))
                .orElse(false);
    }
}
