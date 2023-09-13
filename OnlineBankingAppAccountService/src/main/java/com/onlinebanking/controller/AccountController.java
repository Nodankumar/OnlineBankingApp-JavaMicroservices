package com.onlinebanking.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.models.Account;
import com.onlinebanking.servicesImplementation.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	@Qualifier(value="AccountService")
	AccountService accountService;
	
	
	@GetMapping("getAllAccounts")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("get-Account/{id}")
	public Account getById(@PathVariable int id) {
		return accountService.getByIdAccount(id);
	}
	
	@PostMapping("createAccount")
	public Account newAccount (@RequestBody Account account ) {
		return accountService.CreateAccount(account);
	}
	
	@GetMapping("deposit/{id}/{balance}") 
	public Account deposit(@PathVariable int id, @PathVariable BigDecimal balance) {
		return accountService.depositAmount(id, balance);
	}
	
	@GetMapping("withdraw/{id}/{balance}") 
	public Account withdraw(@PathVariable int id, @PathVariable BigDecimal balance) {
		return accountService.WithdrawAmount(id, balance);
	}
	
}
