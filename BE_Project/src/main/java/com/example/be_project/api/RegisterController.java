package com.example.be_project.api;


import com.example.be_project.model.Account;
import com.example.be_project.model.AccountRole;
import com.example.be_project.model.Customer;
import com.example.be_project.model.RegisterRequest;
import com.example.be_project.repository.AccountRepository;
import com.example.be_project.repository.AccountRoleRepository;
import com.example.be_project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @PostMapping("/register")
    public Account register(@RequestBody RegisterRequest registerRequest) {
        Account account = registerRequest.getAccount();
        Customer customer = registerRequest.getCustomer();
        AccountRole role = new AccountRole();
        // Check if the account already exists
        if (accountRepository.findByAccountUsername(account.getAccountUsername()) != null) {
            throw new RuntimeException("Tài khoản đã tồn tại");
        }

        // Save the new account to the database and get the generated ID
        account = accountRepository.save(account);
        int accountId = account.getAccountId(); // Lấy ID của "account"
        role.setAccountId(accountId);
        role.setRoleId(1);
        accountRoleRepository.save(role);
        // Set the Customer's ID to match the Account's ID
        customer.setCustomerId(accountId);

        // Save the new Customer to the database
        customerRepository.save(customer);

        return account;
    }
}
