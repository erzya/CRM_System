package com.controller;

import com.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by erzyasd on 12.11.15.
 */
@Controller
public class OrderController {

    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService){
        this.orderService =orderService;
    }
    @ResponseBody
    @RequestMapping(value = "/orders/list",method = RequestMethod.GET)
    public List<Order> geOrdertList(Model model){
        List<Order> orderList = orderService.getOrders();
        return orderList;
    }
    @ResponseBody
    @RequestMapping(value = "/orders/{orderId}",method = RequestMethod.GET)
    public Order getOrder(@PathVariable("orderId") Integer orderId){
        Order order = orderService.getOrder();
        return order;
    }
    @RequestMapping(value = "/orders/create/{order}",method = RequestMethod.POST)
    public void createOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }
    @RequestMapping(value = "/orders/update/{order}",method = RequestMethod.POST)
    public void deleteOrder(@RequestBody Order order){
        orderService.updateOrder(order);
    }
    @RequestMapping(value = "/orders/delete/{order}",method = RequestMethod.POST)
    public void deleteOrder(@RequestBody Order order){
        orderService.deleteOrder(order);
    }



}
