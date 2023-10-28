package com.example.be_project.api;

import com.example.be_project.model.Account;
import com.example.be_project.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private AccountRepository accountRepository;
    @PostMapping("/login")
    public Account login(@RequestBody Account account) {
        // Tìm kiếm tài khoản dựa trên username và password
        Account existingAccount = accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword());
        if (existingAccount == null) {
            throw new RuntimeException("Tên đăng nhập hoặc mật khẩu không đúng");
        }
        return existingAccount;
    }
    @GetMapping("/list")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
