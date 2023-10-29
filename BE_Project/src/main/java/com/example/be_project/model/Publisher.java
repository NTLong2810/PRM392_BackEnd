package com.example.be_project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int publisherId;

    @Column(name = "publisher_name")
    private String publisherName;

    // Getter and setter methods
}