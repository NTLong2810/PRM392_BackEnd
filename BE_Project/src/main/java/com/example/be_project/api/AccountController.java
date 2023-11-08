package com.example.be_project.api;

import com.example.be_project.model.Account;
import com.example.be_project.model.AccountRole;
import com.example.be_project.model.Customer;
import com.example.be_project.repository.AccountRepository;
import com.example.be_project.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private AccountRepository accountRepository;
}
