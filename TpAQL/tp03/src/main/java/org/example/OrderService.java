package org.example;

public class OrderService {
    private OrderDao orderDao;
    public boolean createOrder(Order o) {
        return orderDao.saveOrder(o);
    }
    public OrderService(OrderDao oD) {
        this.orderDao = oD;
    }

}