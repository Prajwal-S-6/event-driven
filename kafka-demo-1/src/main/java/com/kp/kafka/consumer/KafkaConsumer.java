package com.kp.kafka.consumer;

import com.kp.kafka.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"demo_topic"}, groupId = "demo_group")
    public void consumeMessage(String message) {
        log.info("Consumed Message: {}", message);
    }

    @KafkaListener(topics = {"demo_topic_user"}, groupId = "demo_group")
    public void consumeUserDetails(User message) {
        log.info("Consumed User Details: {}", message);
    }
}
