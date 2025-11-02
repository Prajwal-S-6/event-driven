package com.kp.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;


@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() {
        Message<String> message = MessageBuilder
                .withPayload("Hello world!!")
                .setHeader(TOPIC, "demo_topic")
                .build();
        kafkaTemplate.send(message);

    }
}
