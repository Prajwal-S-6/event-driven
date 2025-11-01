package com.kp.rabbitmq.controller;

import com.kp.rabbitmq.producer.RMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    private final RMQProducer rmqProducer;

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestParam(name = "message") String message) {
        rmqProducer.sendMessage(message);
        return ResponseEntity.accepted().build();
    }

}
