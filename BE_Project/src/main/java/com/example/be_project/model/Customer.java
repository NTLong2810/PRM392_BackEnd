package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @ManyToOne
    @JoinColumn(name = "customer_address")
    private Address customerAddress;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Lob
    @Column(name = "customer_image")
    private String customerImage;

    @Column(name = "customer_type_sign_in")
    private int customerTypeSignIn;

    // Getter and setter methods
}