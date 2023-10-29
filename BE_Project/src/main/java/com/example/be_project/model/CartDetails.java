package com.example.be_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "CartDetails")
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_details_id")
    private Long cartDetailsId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "quantity")
    private int quantity;

    // Getter and setter methods
}