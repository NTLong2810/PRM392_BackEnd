package com.example.be_project.repository;

import com.example.be_project.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
    Account findByUsernameAndPassword(String username, String password);
}