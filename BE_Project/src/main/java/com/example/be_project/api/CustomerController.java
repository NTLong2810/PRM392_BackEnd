package com.example.be_project.api;

import com.example.be_project.model.Account;
import com.example.be_project.model.Customer;
import com.example.be_project.repository.AccountRepository;
import com.example.be_project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/customer/list")
    public List<Customer> getAllAccounts() {
        return customerRepository.findAll();
    }
}
