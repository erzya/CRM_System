package com.controller;

import com.model.Client;
import com.model.Employee;
import com.service.ClientService;
import com.service.EmployeeService;
import com.service.OrderService;
import com.service.TransporterService;
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

    /*@Autowired
    SessionFactory sessionFactory;
*/
    private ClientService clientService;
    private EmployeeService employeeService;
    private OrderService orderService;
    private TransporterService transporterService;

    @Autowired
    public HomeController(ClientService clientService, EmployeeService employeeService, OrderService orderService, TransporterService transporterService) {
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.orderService = orderService;
        this.transporterService = transporterService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String begin(Model model) {
        model.addAttribute("clients", clientService);
        model.addAttribute("employees", employeeService);
        model.addAttribute("orders", orderService);
        model.addAttribute("transporters", transporterService);
        return "index";
    }

   /* @RequestMapping(value = "/item", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> listAll(Model model) {
        Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, ClassMetadata> pair : map.entrySet()) {
            list.add(pair.getKey());
        }
        return list;
    }*/
}
