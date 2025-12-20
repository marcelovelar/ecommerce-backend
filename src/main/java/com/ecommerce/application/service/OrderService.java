package com.ecommerce.application.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.application.dto.CreateOrderDTO;
import com.ecommerce.application.dto.CreateOrderItemDTO;
import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.application.mapper.OrderMapper;
import com.ecommerce.domain.enums.OrderStatus;
import com.ecommerce.domain.model.Customer;
import com.ecommerce.domain.model.Order;
import com.ecommerce.domain.model.OrderItem;
import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.repository.CustomerRepository;
import com.ecommerce.domain.repository.OrderRepository;
import com.ecommerce.domain.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderDTO createOrder(CreateOrderDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.PENDING);
        order.setItems(new ArrayList<>());

        BigDecimal total = BigDecimal.ZERO;

        for (CreateOrderItemDTO itemDTO : dto.getItems()) {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() < itemDTO.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            // Update stock
            product.setStock(product.getStock() - itemDTO.getQuantity());
            productRepository.save(product);

            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemDTO.getQuantity())
                    .price(product.getPrice()) // Price at the time of purchase
                    .build();

            order.getItems().add(orderItem);

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(itemDTO.getQuantity()));
            total = total.add(itemTotal);
        }

        order.setTotal(total);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDTO(savedOrder);
    }
}
