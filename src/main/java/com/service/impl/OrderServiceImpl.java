package com.service.impl;

import com.dao.OrderDao;
import com.model.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    public void deleteOrder(int id_order) {
        orderDao.deleteOrder(id_order);
    }

    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    public Order getOrder(int id_order) {
        return orderDao.getOrder(id_order);
    }

    public List<Order> getOrders() {
        return orderDao.getOrders();
    }
}
