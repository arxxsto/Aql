package org.example;

public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    public boolean createOrder(Order order) {
        return orderService.createOrder(order);
    }
}