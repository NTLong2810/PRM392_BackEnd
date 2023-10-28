package com.example.be_project.api;


import com.example.be_project.model.Account;
import com.example.be_project.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private AccountRepository accountRepository;
    @PostMapping("/register")
    public Account register(@RequestBody Account account) {
        // Kiểm tra xem tài khoản đã tồn tại chưa
        if (accountRepository.findByAccountUsername(account.getAccountUsername()) != null) {
            throw new RuntimeException("Tài khoản đã tồn tại");
        }

        // Lưu tài khoản mới vào cơ sở dữ liệu
        return accountRepository.save(account);
    }
}
