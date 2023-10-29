package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int orderDetailsId;

    @Column(name = "order_id")
    private int orderId;


    @Column(name = "book_id")
    private int bookId;

    @Column(name = "quantity")
    private int quantity;

    // Getter and setter methods
}