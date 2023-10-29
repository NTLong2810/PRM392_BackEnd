package com.example.be_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int orderDetailsId;

    @Column(name = "order_id")
    private int orderId;


    @Column(name = "book_id")
    private int bookId;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "unit_price")
    private double unit_price;

    // Getter and setter methods
}