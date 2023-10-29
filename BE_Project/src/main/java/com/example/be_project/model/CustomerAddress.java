package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name="Customer_Address")
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "address_id")
    private int addressId;
}
