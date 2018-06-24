package com.qa.account.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class AccountController {
	
    private AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/select-accounts")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Account> selectAccounts() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

}
