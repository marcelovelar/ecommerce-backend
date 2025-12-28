package com.ecommerce.infrastructure.adapter.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.application.dto.CreateOrderDTO;
import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.application.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody CreateOrderDTO dto) {
        return new ResponseEntity<>(orderService.createOrder(dto), HttpStatus.CREATED);
    }

    @org.springframework.web.bind.annotation.GetMapping
    public ResponseEntity<java.util.List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @org.springframework.web.bind.annotation.GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@org.springframework.web.bind.annotation.PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}
