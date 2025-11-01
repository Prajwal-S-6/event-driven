package com.kp.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${kp.rmq.demo.topic.exchange-name}")
    private String topicExchangeName;

    @Value("${kp.rmq.demo.direct.exchange-name}")
    private String directExchangeName;

    @Value("${kp.rmq.demo.queue-name}")
    private String queueName;

    @Value("${kp.rmq.demo.topic.routing-key}")
    private String routingKeyForTopicExchange;

    @Value("${kp.rmq.demo.direct.routing-key}")
    private String routingKeyForDirectExchange;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(directExchangeName);
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    public Binding bindingTopicExchange() {
        return BindingBuilder.bind(queue())
                .to(topicExchange())
                .with(routingKeyForTopicExchange);
    }

    @Bean
    public Binding bindingDirectExchange() {
        return BindingBuilder.bind(queue())
                .to(directExchange())
                .with(routingKeyForDirectExchange);
    }

}
