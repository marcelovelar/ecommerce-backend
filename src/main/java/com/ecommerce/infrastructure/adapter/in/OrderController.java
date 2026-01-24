package com.ecommerce.infrastructure.adapter.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.application.dto.CreateOrderDTO;
import com.ecommerce.application.dto.CreateProductDTO;
import com.ecommerce.application.dto.OrderDTO;
import com.ecommerce.application.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody CreateOrderDTO dto) {
        return new ResponseEntity<>(orderService.createOrder(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<java.util.List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id,
    // @RequestBody CreateOrderDTO dto) {
    // return ResponseEntity.ok(orderService.updateOrder(id, dto));
    // }
}
