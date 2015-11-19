package com.controller;

import com.model.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseBody
    @RequestMapping(value = "/orders/list", method = RequestMethod.GET)
    public List<Order> geOrdertList(Model model) {
        List<Order> orderList = orderService.getOrders();
        return orderList;
    }

    @ResponseBody
    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable("orderId") int id_order) {
        Order order = orderService.getOrder(id_order);
        return order;
    }

    @RequestMapping(value = "/orders/create/{order}", method = RequestMethod.POST)
    public void createOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @RequestMapping(value = "/orders/update/{order}", method = RequestMethod.POST)
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }

    @RequestMapping(value = "/orders/delete/{order}", method = RequestMethod.POST)
    public void deleteOrder(@RequestBody int id_order) {
        orderService.deleteOrder(id_order);
    }
}
