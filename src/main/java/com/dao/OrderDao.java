package com.dao;

import com.model.Order;

import java.util.List;

public interface OrderDao {
    public void addOrder(Order order);

    public void deleteOrder(int id_order);

    public void updateOrder(int id_order);

    public Order getOrder(int id_order);

    public List<Order> getOrders();
}
