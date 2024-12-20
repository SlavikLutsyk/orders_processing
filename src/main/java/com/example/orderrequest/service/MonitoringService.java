package com.example.orderrequest.service;

import com.example.orderrequest.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MonitoringService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @KafkaListener(topics = "order-processed", groupId = "monitoring-group")
    public void monitorOrders(Order order) {
        mongoTemplate.save(order);
        System.out.println("Order saved to analytics DB: " + order);
    }
}
