package com.ecommerce.application.dto;

import lombok.Data;
import java.util.Set;

@Data
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<String> roles;
}
