package com.kp.kafka.consumer;

import com.kp.kafka.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class OrderConsumer {

    @Bean
    public Consumer<Order> orderConsumer() {
        return (order) -> log.info("Consumed Order: {}", order);
    }
}
