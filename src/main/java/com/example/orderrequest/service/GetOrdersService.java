package com.example.orderrequest.service;

import com.example.orderrequest.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrdersService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public GetOrdersService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Order> getOrders() {
        return mongoTemplate.findAll(Order.class);
    }
}
