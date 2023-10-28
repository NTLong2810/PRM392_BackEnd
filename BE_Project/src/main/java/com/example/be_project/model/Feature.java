package com.example.be_project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Feature")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feature_id")
    private int featureId;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "feature_url")
    private String featureUrl;
    @ManyToMany(mappedBy = "features")
    private List<Role> roles;

    // Constructors, getters, and setters
}