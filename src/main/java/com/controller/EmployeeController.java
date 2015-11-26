package com.controller;

import com.model.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ResponseBody
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployees();
    }

    @ResponseBody
    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
    public Employee getClient(@PathVariable("employeeId") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/employees/new", method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(value = "/employees/update/{employeeId}", method = RequestMethod.POST)
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/employees/del/{employeeId}", method = RequestMethod.POST)
    public void deleteClient(@PathVariable("employeeId") int employeeId) {
        System.out.println(employeeId);
        employeeService.deleteEmployee(employeeId);
    }
}
