package com.service;

import com.model.Order;

import java.util.List;

public interface OrderService {

    public void addOrder(Order order);

    public void deleteOrder(int id_order);

    public void updateOrder(Order order);

    public Order getOrder(int id_order);

    public List<Order> getOrders();
}
