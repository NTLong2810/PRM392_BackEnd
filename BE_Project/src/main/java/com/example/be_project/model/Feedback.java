package com.example.be_project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackId;

    @Column(name = "feedback_description")
    private String feedbackDescription;

    @Column(name = "feedback_time")
    private Date feedbackTime;

    @Column(name = "feedback_rate")
    private int feedbackRate;

    @Column(name = "customer_id")
    private Long customerId;


    // Getter and setter methods
}