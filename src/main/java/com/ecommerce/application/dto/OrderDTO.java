package com.ecommerce.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private LocalDateTime createdAt;
    private String status;
    private BigDecimal total;
    private String customerName;
    private List<OrderItemDTO> items;
}
