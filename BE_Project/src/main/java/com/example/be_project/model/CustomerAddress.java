package com.example.be_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer_Address")
public class CustomerAddress {
    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "address_id")
    private int addressId;
}

