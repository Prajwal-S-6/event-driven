package com.kp.kafka.controller;

import com.kp.kafka.producer.KafkaProducer;
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

    private final KafkaProducer kafkaProducer;

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.accepted().build();
    }
}
