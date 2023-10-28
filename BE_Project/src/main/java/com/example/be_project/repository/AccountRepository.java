package com.example.be_project.repository;

import com.example.be_project.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountUsername(String username);
    Account findByAccountUsernameAndAccountPassword(String username, String password);
}