package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Feature")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    private int featureId;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "feature_url")
    private String featureUrl;

    // Constructors, getters, and setters
}