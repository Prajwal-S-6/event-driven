package com.kp.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${kp.rmq.demo.topic.exchange-name}")
    private String exchangeName;

    @Value("${kp.rmq.demo.queue-name}")
    private String queueName;

    @Value("${kp.rmq.demo.topic.routing-key}")
    private String routingKey;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(topicExchange())
                .with(routingKey);
    }

}
