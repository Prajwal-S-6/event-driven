package com.kp.rabbitmq.controller;

import com.kp.rabbitmq.dto.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class DemoController {

    private final StreamBridge streamBridge;

    @PostMapping("/sendOrder")
    public ResponseEntity<String> sendOrder() {
        streamBridge.send("orderPublisher", new Order("ORD123", "Laptop"));
        return ResponseEntity.accepted().build();
    }
}
