package com.example.be_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Account_Role")
@IdClass(AccountRoleId.class)
public class AccountRole {
    @Id
    @Column(name = "account_id")
    private int accountId;

    @Id
    @Column(name = "role_id")
    private int roleId;

    // Constructors, getters, and setters

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}