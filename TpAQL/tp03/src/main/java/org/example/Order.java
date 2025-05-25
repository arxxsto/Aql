package org.example;

public class Order {
    private long orderId;
    private String customerName;
    private double amount;
    public Order(long orderId, String customerName, double amount) {
        this.amount = amount;
        this.orderId = orderId;
        this.customerName = customerName;
    }
    public long getOrderId() {
        return orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
}