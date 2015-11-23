package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    @Id
    @Column(name = "id_emp")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_emp;

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 30, message = "Name should have {min} - {max} characters")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Name:Only letters allowed")
    private String name;


    @Column(name = "surname")
    @NotNull
    @Size(min = 3, max = 30, message = "Name should have {min} - {max} characters")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Name:Only letters allowed")
    private String surname;

    @Column(name = "isActive")
    private boolean isActive;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>(0);

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Employee(String name, String surname, boolean isActive) {
        this.name = name;
        this.surname = surname;
        this.isActive = isActive;
    }

    public Employee() {
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
