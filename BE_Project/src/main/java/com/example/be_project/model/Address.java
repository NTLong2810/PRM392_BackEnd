package com.example.be_project.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "address_description")
    private String addressDescription;

    // Getter and setter methods
}