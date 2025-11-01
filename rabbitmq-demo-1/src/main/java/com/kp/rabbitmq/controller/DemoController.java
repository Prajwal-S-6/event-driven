package com.kp.rabbitmq.controller;

import com.kp.rabbitmq.dto.User;
import com.kp.rabbitmq.producer.RMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/sendUserDetails")
    public ResponseEntity<String> sendUserDetails(@RequestBody User user) {
        rmqProducer.sendUserDetails(user);
        return ResponseEntity.accepted().build();
    }

}
