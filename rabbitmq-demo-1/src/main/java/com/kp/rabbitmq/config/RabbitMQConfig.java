package com.kp.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${kp.rmq.demo.topic.exchange-name}")
    private String topicExchangeName;

    @Value("${kp.rmq.demo.direct.exchange-name}")
    private String directExchangeName;

    @Value("${kp.rmq.demo.fanout.exchange-name}")
    private String fanoutExchangeName;

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
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchangeName);
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
    public TopicExchange exchange() {
        return new TopicExchange("order-events");
    }
    @Bean
    public Queue orderQueue() {
        return new Queue("order_queue");
    }

    @Bean
    public Binding orderQueueBinding() {
        return BindingBuilder.bind(orderQueue())
                .to(exchange())
                .with("#");
    }

    @Bean
    public Binding bindingExchange1() {
        return BindingBuilder.bind(queue1())
                .to(topicExchange())
                .with(routingKeyForTopicExchange);
    }

    @Bean
    public Binding bindingExchange2() {
        return BindingBuilder.bind(queue2())
                .to(topicExchange())
                .with(routingKeyForDirectExchange);
    }

    @Bean
    public Binding bindingExchange3() {
        return BindingBuilder.bind(queue1())
                .to(directExchange())
                .with(routingKeyForTopicExchange);
    }

    @Bean
    public Binding bindingExchange4() {
        return BindingBuilder.bind(queue2())
                .to(directExchange())
                .with(routingKeyForDirectExchange);
    }

    @Bean
    public Binding bindingExchange5() {
        return BindingBuilder.bind(queue1())
                .to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchange6() {
        return BindingBuilder.bind(queue2())
                .to(fanoutExchange());
    }

    @Bean(name = "amqpMessageConverter")
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(@Qualifier("amqpMessageConverter") MessageConverter messageConverter, ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }


}
