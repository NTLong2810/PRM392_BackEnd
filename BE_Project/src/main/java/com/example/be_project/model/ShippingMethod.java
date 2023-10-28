package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ShippingMethod")
public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shippoing_method_id") // Có vẻ có lỗi chính tả ở đây, sửa thành "shipping_method_id"
    private int shippingMethodId;

    @Column(name = "shipping_method_name")
    private String shippingMethodName;

    @Column(name = "price")
    private Double price;

    // Getter and setter methods
}