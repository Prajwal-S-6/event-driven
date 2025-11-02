package com.kp.kafka.config;

import com.kp.kafka.dto.Order;
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
}
