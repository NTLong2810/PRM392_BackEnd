package com.example.be_project.api;

import com.example.be_project.DTO.CartDetailDTO;
import com.example.be_project.model.Account;
import com.example.be_project.model.Customer;
import com.example.be_project.repository.AccountRepository;
import com.example.be_project.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/customer/list")
    public List<Customer> getAllAccounts() {
        return customerRepository.findAll();
    }
    @GetMapping("/customer/info/")
    public ResponseEntity<?>  getCustomerById(@RequestParam int customerId){
        System.out.println("CUSTOMER_ID: " + customerId);
        Customer customer = customerRepository.getByCustomerId(customerId);
        return new ResponseEntity<>(customer, HttpStatusCode.valueOf(200));
    }
}
