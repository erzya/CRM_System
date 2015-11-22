package com.dao.impl;

import com.dao.OrderDao;
import com.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addOrder(Order order) {
        getCurrentSession().save(order);
    }

    public void deleteOrder(int id_order) {
        Order order = getOrder(id_order);
        if (order != null) getCurrentSession().delete(order);
    }

    public void updateOrder(Order order) {
        Order orderToUpdate = getOrder(order.getId_order());
        orderToUpdate.setOrderscol(order.getOrderscol());
        orderToUpdate.setClient(order.getClient());
        orderToUpdate.setEmployee(order.getEmployee());
        orderToUpdate.setTransporter(order.getTransporter());
        getCurrentSession().update(orderToUpdate);
    }

    public Order getOrder(int id_order) {
        Order order = (Order) getCurrentSession().get(Order.class, id_order);
        return order;
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrders() {
        return getCurrentSession().createQuery("from Order").list();
    }
}
