package com.kp.kafka.controller;

import com.kp.kafka.dto.Order;
import com.kp.kafka.producer.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping("/sendOrder")
    public ResponseEntity<String> sendOrder(@RequestBody Order order) {
        orderProducer.sendOrderDetails(order);
        return ResponseEntity.accepted().build();
    }
}
