package com.qa.account.app;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AccountController {
	
    private AccountRepository repository;
    private JSONUtil util;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
        util = new JSONUtil();
    }

    @GetMapping("/select-accounts")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Collection<Account> selectAccounts() {
        return repository.findAll().stream().collect(Collectors.toList());
    }
    
	@PostMapping("/account-add")
	@CrossOrigin(origins = "http://localhost:4200")
    public String createAccount(@RequestBody String account){
		Account newAccount = util.getObjectForJSON(account, Account.class);
    	repository.save(newAccount);
    	return "{\"message\" : \"Account successfully created\"}";
    }
	
	@PutMapping("/account-edit/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public String updateCustomer(@PathVariable long id, @RequestBody String account) {
		
		Account accountToUpdate = util.getObjectForJSON(account, Account.class);
    	Account existingAccount = repository.findById(id).get();
    	
    	existingAccount.setFirstName(accountToUpdate.getFirstName());
    	existingAccount.setLastName(accountToUpdate.getLastName());
    	existingAccount.setAccountNumber(accountToUpdate.getAccountNumber());
    	
    	repository.save(existingAccount);
    	return "{\"message\" : \"Account successfully updated\"}";
    }
	
	@DeleteMapping(value="/delete-account/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public String returnRequestBody(@PathVariable long id){
		repository.deleteById(id);
    	return "{\"message\" : \"Account successfully deleted\"}";
    }
	
}
