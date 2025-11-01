package com.kp.rabbitmq.consumer;

import com.kp.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RMQConsumer {
    Logger logger = LoggerFactory.getLogger(RMQConsumer.class);

//    @RabbitListener(queues = {"${kp.rmq.demo.queue-name-1}"})
//    public void consumer1(String message) {
//        logger.info("Received Message from Queue 1: {}", message);
//    }
//
//    @RabbitListener(queues = {"${kp.rmq.demo.queue-name-2}"})
//    public void consumer2(String message) {
//        logger.info("Received Message from Queue 2: {}", message);
//    }

    @RabbitListener(queues = {"${kp.rmq.demo.queue-name-1}"})
    public void consumer3(User user) {
        logger.info("Received Message from Queue 1: {}", user);
    }

    @RabbitListener(queues = {"${kp.rmq.demo.queue-name-2}"})
    public void consumer4(User user) {
        logger.info("Received Message from Queue 2: {}", user);
    }
}
