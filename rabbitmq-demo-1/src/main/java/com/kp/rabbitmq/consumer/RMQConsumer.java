package com.kp.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RMQConsumer {
    Logger logger = LoggerFactory.getLogger(RMQConsumer.class);

    @RabbitListener(queues = {"${kp.rmq.demo.queue-name}"})
    public void consumer(String message) {
        logger.info("Received Message: {}", message);
    }
}
