package com.example.be_project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "message_content")
    private String messageContent;

    @Column(name = "message_datetime")
    private Date messageDatetime;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    // Getter and setter methods
}