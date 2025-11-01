package com.kp.rabbitmq.producer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RMQProducer {

    Logger logger = LoggerFactory.getLogger(RMQProducer.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${kp.rmq.demo.routing-key}")
    private String routingKey;

    @Value("${kp.rmq.demo.topic.exchange-name}")
    private String exchangeName;

    public void sendMessage(String message) {
        logger.info("Sending message: {}", message);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
