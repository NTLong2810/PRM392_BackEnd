package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_details_id")
    private int orderDetailsId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private int bookId;

    @Column(name = "quantity")
    private int quantity;

    // Getter and setter methods
}