package com.example.be_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@Table(name = "Orders")
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

    @Column(name = "address")
    private String address;

    @Transient
    private List<OrderDetails> orderDetailsList;

    // Getter and setter methods
}
