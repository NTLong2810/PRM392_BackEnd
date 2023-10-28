package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderStatus")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id")
    private int orderStatusId;

    @Column(name = "order_status_name")
    private String orderStatusName;

    // Getter and setter methods
}