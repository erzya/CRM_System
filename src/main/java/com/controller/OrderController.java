package com.controller;

import com.model.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseBody
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> geOrdertList() {
        return orderService.getOrders();
    }

    @ResponseBody
    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable("orderId") int orderId) {
       return orderService.getOrder(orderId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/orders/new", method = RequestMethod.POST)
    public void createOrder(@RequestBody Order order) {

        orderService.addOrder(order);
    }

    @RequestMapping(value = "/orders/update/{orderId}", method = RequestMethod.POST)
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/orders/del/{orderId}", method = RequestMethod.POST)
    public void deleteOrder(@PathVariable("orderId") int orderId) {
        orderService.deleteOrder(orderId);
    }
}