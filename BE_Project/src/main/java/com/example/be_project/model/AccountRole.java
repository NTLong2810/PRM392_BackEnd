package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Account_Role")
public class AccountRole {
    @Id
    @Column(name = "account_id")
    private Account account;

    @Id
    @Column(name = "role_id")
    private Role role;

    // Constructors, getters, and setters
}