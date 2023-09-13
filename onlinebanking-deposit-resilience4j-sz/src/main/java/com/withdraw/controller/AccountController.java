package com.withdraw.controller;


import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.withdraw.entity.Account;
import com.withdraw.proxy.AccountProxy;

@RestController
public class AccountController {
	
	@Autowired
	AccountProxy accountProxy;
	
	
	private static Logger log = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping("getAllAccounts")
	 public List<Account> getAllAccounts() {
       List<Account> accounts = accountProxy.getAllAccounts();
       log.debug("In getAllAccounts with return value accounts: " + accounts);
       return accounts;
   }
	
	
	@GetMapping("get-account/{id}")
	public Account getAccountById(@PathVariable int id) {
		Account account = accountProxy.getById(id);
		log.debug("In getAccountById with return value:" + account);
		return account;
	}
	
	
	@GetMapping("deposit/{id}/{balance}")
	public Account deposit(@PathVariable int id, @PathVariable BigDecimal balance) {
		Account account  =  accountProxy.deposit(id, balance);
		log.debug("In deposit with return value:" + account);
		return account;
	}
	
	
	@PostMapping("createAccount")
	public Account newAccount (@RequestBody Account account ) {
		Account accounts = accountProxy.newAccount(account);
		log.debug("In newAccount with return value:" + accounts);
		return accounts;
		
	}
	
	

}