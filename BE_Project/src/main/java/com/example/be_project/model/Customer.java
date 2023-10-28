package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_address")
    private int customerAddress;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_image")
    private String customerImage;

    // Getter and setter methods
}