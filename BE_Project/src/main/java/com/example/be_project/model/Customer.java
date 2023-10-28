package com.example.be_project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;


    @Column(name = "customer_address")
    private Long AddressId;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_image")
    private String customerImage;

    // Getter and setter methods
}