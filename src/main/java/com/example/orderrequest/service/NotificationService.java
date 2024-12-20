package com.example.orderrequest.service;

import com.example.orderrequest.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(topics = "order-processed", groupId = "notification-group")
    public void notifyCustomer(Order order) {
        System.out.println("Notifying customer: " + order);
    }
}
