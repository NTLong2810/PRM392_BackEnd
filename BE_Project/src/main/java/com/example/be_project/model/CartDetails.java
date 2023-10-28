package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CartDetails")
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_details_id")
    private int cartDetailsId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "quantity")
    private int quantity;

    // Getter and setter methods
}