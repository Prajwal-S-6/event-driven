package com.kp.kafka.config;

import com.kp.kafka.dto.Order;
import com.kp.kafka.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ConsumerConfig {

    @Bean
    public Consumer<Order> orderConsumer() {
        return (order) -> log.info("Consumed Order: {}", order);
    }

    @Bean
    public Consumer<User> userConsumer() {
        return (user) -> log.info("Consumed User: {}", user);
    }
}
