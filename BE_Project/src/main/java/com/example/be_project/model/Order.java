package com.example.be_project.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "payment_method_id")
    private int paymentMethodId;

    @Column(name = "seller_id")
    private int sellerId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "price")
    private Double price;


    @Column(name = "order_status_id")
    private int orderStatusId;

    @Column(name = "order_datetime")
    private Date orderDatetime;

    @Column(name = "shipped_datetime")
    private Date shippedDatetime;


    @Column(name = "shipping_method_id")
    private int shippingMethodId;

    // Getter and setter methods
}
