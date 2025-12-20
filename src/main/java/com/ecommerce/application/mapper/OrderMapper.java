package com.ecommerce.application.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.application.dto.OrderItemDTO;
import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.model.OrderItem;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setStatus(order.getStatus().name());
        dto.setTotal(order.getTotal());

        if (order.getCustomer() != null) {
            dto.setCustomerName(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
        }

        if (order.getItems() != null) {
            dto.setItems(order.getItems().stream()
                    .map(this::toItemDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    private OrderItemDTO toItemDTO(OrderItem item) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setProductName(item.getProduct().getName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        return dto;
    }
}
