package com.service.impl;

import com.dao.EmployeeDao;
import com.model.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void deleteEmployee(int id_emp) {
        employeeDao.deleteEmployee(id_emp);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public Employee getEmployee(int id_emp) {
        return employeeDao.getEmployee(id_emp);
    }

    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }
}
