package com.onlinebanking.services;

import java.math.BigDecimal;

import java.util.List;

import com.onlinebanking.models.Account;




public interface iAccountService {
	
	
	public List<Account> getAllAccounts();
	public Account getByIdAccount(int id);
	public Account CreateAccount(Account account);
	
	public Account depositAmount(int id, BigDecimal amount);
	public Account WithdrawAmount(int id, BigDecimal amount);

	
}
