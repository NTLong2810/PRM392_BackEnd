package com.example.be_project.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "supplier_name")
    private String supplierName;
}