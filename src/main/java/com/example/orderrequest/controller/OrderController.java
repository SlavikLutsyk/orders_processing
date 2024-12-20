package com.example.orderrequest.controller;

import com.example.orderrequest.model.Order;
import com.example.orderrequest.service.GetOrdersService;
import com.example.orderrequest.service.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer orderProducer;
    private final GetOrdersService getOrdersService;

    @Autowired
    public OrderController(OrderProducer orderProducer, GetOrdersService getOrdersService) {
        this.orderProducer = orderProducer;
        this.getOrdersService = getOrdersService;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        order.setStatus("PENDING");
        orderProducer.sendOrder(order);
        return "Order placed successfully!";
    }
    @GetMapping
    public List<Order> getOrders() {
        return getOrdersService.getOrders();
    }
}
