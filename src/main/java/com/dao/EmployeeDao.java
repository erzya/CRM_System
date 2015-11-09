package com.dao;

import com.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public void addEmployee(Employee employee);

    public void deleteEmployee(int id_emp);

    public void updateEmployee(int id_emp);

    public Employee getEmployee(int id_emp);

    public List<Employee> getEmployees();
}
