package com.kp.kafka.controller;

import com.kp.kafka.dto.User;
import com.kp.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/sendUserDetails")
    public ResponseEntity<String> sendUserDetails(@RequestBody User user) {
        kafkaProducer.sendUserDetails(user);
        return ResponseEntity.accepted().build();
    }
}
