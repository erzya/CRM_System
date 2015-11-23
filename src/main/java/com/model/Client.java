package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client implements Serializable {
    @Id
    @Column(name = "id_cl")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_cl;

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 30, message = "Name should have {min} - {max} characters")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Name:Only letters allowed")
    private String name;

    @Column(name = "telephone")
    @NotNull
    @Size(min = 7, max = 13, message = "Telephone number should have {min} - {max} characters")
    @Pattern(regexp = "^[0-9]*$", message = "Only digits allowed")
    private String telephone;

    @Column(name = "details")
    @Size(min = 10, max = 100)
    private String details;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>(0);

    public Client(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public Client(String name, String telephone, String details) {
        this.name = name;
        this.telephone = telephone;
        this.details = details;
    }

    public Client() {
    }

    public int getId_cl() {
        return id_cl;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
