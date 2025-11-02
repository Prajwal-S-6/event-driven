package com.kp.kafka;

import com.kp.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaDemo1Application implements CommandLineRunner {

    private final KafkaProducer kafkaProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        kafkaProducer.sendMessage();
    }
}
