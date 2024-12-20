package com.example.orderrequest.service;

import com.example.orderrequest.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessor {

    private final OrderProducer orderProducer;

    public OrderProcessor(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @KafkaListener(topics = "order-requests", groupId = "order-processing-group")
    public void processOrder(Order order) {
        order.setStatus("PROCESSED");
        orderProducer.sendProcessedOrder(order);
        System.out.println("Processed order: " + order);
    }
}
