package com.dao.impl;

import com.dao.EmployeeDao;
import com.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addEmployee(Employee employee) {
        getCurrentSession().save(employee);
    }

    public void deleteEmployee(int id_emp) {
        Employee employee = getEmployee(id_emp);
        if (employee != null) getCurrentSession().delete(employee);
    }

    public void updateEmployee(Employee employee) {
        Employee employeeToUpdate = getEmployee(employee.getId_emp());
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setSurname(employee.getSurname());
        employeeToUpdate.setIsActive(employee.isActive());
        employeeToUpdate.setOrders(employee.getOrders());
        getCurrentSession().update(employeeToUpdate);
    }

    public Employee getEmployee(int id_emp) {
        Employee employee = (Employee) getCurrentSession().get(Employee.class, id_emp);
        return employee;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getEmployees() {
        return getCurrentSession().createQuery("from Employee").list();
    }
}
