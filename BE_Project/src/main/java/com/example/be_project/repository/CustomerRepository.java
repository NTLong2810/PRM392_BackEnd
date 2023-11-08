package com.example.be_project.repository;

import com.example.be_project.model.CartDetails;
import com.example.be_project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // You can add custom query methods here if needed
    Customer getByCustomerId(int customerId);
}