package com.kp.rabbitmq.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${kp.rmq.demo.exchange-name}")
    private String exchangeName;

    @Value("${kp.rmq.demo.queue-name}")
    private String queueName;

    @Value("${kp.rmq.demo.routing-key}")
    private String routingKey;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("");
    }

}
