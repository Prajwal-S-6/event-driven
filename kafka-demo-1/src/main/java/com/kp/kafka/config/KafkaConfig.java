package com.kp.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic newTopic1() {
        return TopicBuilder.name("demo_topic")
                .build();
    }

    @Bean
    public NewTopic newTopic2() {
        return TopicBuilder.name("demo_topic_user")
                .partitions(2)
                .replicas(1)
                .build();
    }
}
