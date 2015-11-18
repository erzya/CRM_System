package com.service;

import com.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void addEmployee(Employee employee);

    public void deleteEmployee(int id_emp);

    public void updateEmployee(Employee employee);

    public Employee getEmployee(int id_emp);

    public List<Employee> getEmployees();
}
