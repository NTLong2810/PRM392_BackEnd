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

    @ManyToOne
    @JoinColumn(name = "customer_address")
    private Address customerAddress;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_image")
    private String customerImage;

    @OneToMany(mappedBy = "customer")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "customer")
    private List<Message> messages;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @OneToMany(mappedBy = "customer")
    private List<CartDetails> cartDetails;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Getter and setter methods
}