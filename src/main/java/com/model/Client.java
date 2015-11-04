package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name ="id_cl")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_cl;

    @Column(name ="name")
    @NotNull
    @Size(min = 3, max = 30, message = "Name should have {min} - {max} characters")
    @Pattern(regexp = "[A-Za-zР-пр-џ]*", message = "Name:Only letters allowed")
    private String name;

    @Column(name ="telephone")
    @NotNull
    @Size(min = 7, max = 13, message = "Telephone number should have {min} - {max} characters")
    @Pattern(regexp = "^[0-9]*$", message = "Only digits allowed")
    private String telephone;

    @Column(name ="details")
    @Size(min = 10, max = 100)
    private String details;

    public Client(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public Client(String name, String telephone, String details) {
        this.name = name;
        this.telephone = telephone;
        this.details = details;
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
}
