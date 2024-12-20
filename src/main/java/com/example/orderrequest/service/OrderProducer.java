package com.example.orderrequest.service;

import com.example.orderrequest.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
        kafkaTemplate.send("order-requests", order);
    }

    public void sendProcessedOrder(Order order) {
        kafkaTemplate.send("order-processed", order);
    }
}
