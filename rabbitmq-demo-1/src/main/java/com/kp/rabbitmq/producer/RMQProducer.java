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

    public void sendMessageToTopicExchange(String message) {
        logTheMessage(message);
        rabbitTemplate.convertAndSend("demo_rmq_exchange_1", "routing.key.any", message);
    }

    public void sendMessageToDirectExchange(String message) {
        logTheMessage(message);
        rabbitTemplate.convertAndSend("demo_rmq_exchange_2", "routing.key.1", message);
    }

    private void logTheMessage(String message) {
        logger.info("Sending message: {}", message);
    }
}
