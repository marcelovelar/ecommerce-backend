package com.ecommerce.application.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Long categoryId;
}
