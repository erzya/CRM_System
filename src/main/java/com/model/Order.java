package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_order;

    @Column(name = "orderscol")
    @Size(min = 2, max = 45, message = "Length should be {min} - {max} characters")
    private String orderscol;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cl")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_emp")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tran")
    private Transporter transporter;

    public Order(Client client, Employee employee, Transporter transporter) {
        this.client = client;
        this.employee = employee;
        this.transporter = transporter;
    }

    public Order(String orderscol, Client client, Employee employee, Transporter transporter) {
        this.orderscol = orderscol;
        this.client = client;
        this.employee = employee;
        this.transporter = transporter;
    }

    public Order() {
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public String getOrderscol() {
        return orderscol;
    }

    public void setOrderscol(String orderscol) {
        this.orderscol = orderscol;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Transporter getTransporter() {
        return transporter;
    }

    public void setTransporter(Transporter transporter) {
        this.transporter = transporter;
    }
}
