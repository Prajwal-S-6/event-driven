package com.kp.kafka.producer;

import com.kp.kafka.dto.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final StreamBridge streamBridge;

    public void sendOrderDetails(Order order) {
        streamBridge.send("order_topic", order);
    }

}
