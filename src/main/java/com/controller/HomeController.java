package com.controller;

import com.service.ClientService;
import com.service.EmployeeService;
import com.service.OrderService;
import com.service.TransporterService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    SessionFactory sessionFactory;

    private ClientService clientService;
    private OrderService orderService;
    private EmployeeService employeeService;
    private TransporterService transporterService;

    @Autowired
    public HomeController(ClientService clientService, OrderService orderService, EmployeeService employeeService, TransporterService transporterService) {
        this.clientService = clientService;
        this.orderService = orderService;
        this.employeeService = employeeService;
        this.transporterService = transporterService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String begin(Model model) {
        model.addAttribute("clients", clientService);
        model.addAttribute("orders", orderService);
        model.addAttribute("employees", employeeService);
        model.addAttribute("transporters", transporterService);
        return "index";
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> listAll(Model model) {
        Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, ClassMetadata> pair : map.entrySet()) {
            list.add(pair.getKey());
        }
        return list;
    }
}

