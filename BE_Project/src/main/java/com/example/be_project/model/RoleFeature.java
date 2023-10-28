package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Role_Feature")
public class RoleFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "feature_id")
    private int featureId;

    // Constructors, getters, and setters
}