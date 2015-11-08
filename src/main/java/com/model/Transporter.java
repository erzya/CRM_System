package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transporters")
public class Transporter {
    @Id
    @Column(name = "id_tran")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_tran;

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 50, message = "Name should have {min} - {max} characters")
    private String name;

    @Column(name = "telephone")
    @NotNull
    @Size(min = 7, max = 15, message = "Telephone number should have {min} - {max} characters")
    @Pattern(regexp = "^[0-9]*$", message = "Only digits allowed")
    private String telephone;

    @Column(name = "type")
    @NotNull
    @Size(min = 2, max = 25, message = "Type should have {min} - {max} characters")
    @Pattern(regexp = "[A-Za-zР-пр-џ]*", message = "Type:Only letters allowed")
    private String type;

    @Column(name = "details")
    @Size(min = 10, max = 150)
    private String details;

    @OneToMany(mappedBy = "transporters", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>(0);

    public Transporter(String name, String telephone, String type) {
        this.name = name;
        this.telephone = telephone;
        this.type = type;
    }

    public Transporter(String name, String telephone, String type, String details) {
        this.name = name;
        this.telephone = telephone;
        this.type = type;
        this.details = details;
    }

    public int getId_tran() {
        return id_tran;
    }

    public void setId_tran(int id_tran) {
        this.id_tran = id_tran;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
