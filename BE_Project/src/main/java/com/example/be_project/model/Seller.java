package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seller_id")
    private int sellerId;

    @Column(name = "seller_name")
    private String sellerName;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
    // Getter and setter methods
}