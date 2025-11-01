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

    @Value("${kp.rmq.demo.queue-name-1}")
    private String queueName1;

    @Value("${kp.rmq.demo.queue-name-2}")
    private String queueName2;

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
    public Queue queue1() {
        return new Queue(queueName1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(queueName2);
    }

    @Bean
    public Binding bindingTopicExchange1() {
        return BindingBuilder.bind(queue1())
                .to(topicExchange())
                .with(routingKeyForTopicExchange);
    }

    @Bean
    public Binding bindingTopicExchange2() {
        return BindingBuilder.bind(queue2())
                .to(topicExchange())
                .with(routingKeyForDirectExchange);
    }


}
