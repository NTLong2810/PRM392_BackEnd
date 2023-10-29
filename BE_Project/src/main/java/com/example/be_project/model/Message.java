package com.example.be_project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private int messageId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "message_content")
    private String messageContent;

    @Column(name = "message_datetime")
    private Date messageDatetime;

    @Column(name = "seller_id")
    private int sellerId;

    // Getter and setter methods
}