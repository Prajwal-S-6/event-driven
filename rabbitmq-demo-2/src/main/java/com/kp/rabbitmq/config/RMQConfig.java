package com.kp.rabbitmq.config;

import com.kp.rabbitmq.dto.Order;
import com.kp.rabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class RMQConfig {

    Logger logger = LoggerFactory.getLogger(RMQConfig.class);
//    @Bean
//    public Supplier<Order> publishOrder() {
//        return () -> new Order("ORD123", "Laptop");
//    }

    @Bean
    public Consumer<Order> orderConsumer() {
        return (order) -> logger.info("Consumed Order: {}", order);
    }

    @Bean
    public Consumer<User> userConsumer() {
        return (user) -> logger.info("Consumed User: {}", user);
    }
}
