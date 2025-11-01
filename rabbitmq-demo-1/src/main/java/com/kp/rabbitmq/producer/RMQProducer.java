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

    public void sendMessage(String message) {
        logTheMessage(message);
        // Topic
        rabbitTemplate.convertAndSend("demo_rmq_exchange_1", "routing.key.any", message);   // goes to Q1
        rabbitTemplate.convertAndSend("demo_rmq_exchange_1", "routing.key.1", message);     // goes to Q2 and Q1

        //Direct
        rabbitTemplate.convertAndSend("demo_rmq_exchange_2", "routing.key.1", message);     // goes to Q2
        rabbitTemplate.convertAndSend("demo_rmq_exchange_2", "routing.key.any", message);   // nowhere
        
        //Fanout
        rabbitTemplate.convertAndSend("demo_rmq_exchange_3", "some-random-key", message);   // goes to Q1 and Q2
    }

    private void logTheMessage(String message) {
        logger.info("Sending message: {}", message);
    }
}
