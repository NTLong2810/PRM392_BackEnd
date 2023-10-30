package com.example.be_project.model;

public class RegisterRequest {
    private Account account;
    private Customer customer;

    // Getters and setters for account and customer

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
