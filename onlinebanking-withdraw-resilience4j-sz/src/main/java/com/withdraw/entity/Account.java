package com.withdraw.entity;

import java.math.BigDecimal;

import java.util.List;

public class Account {

    
    private int id;
    private String accountType;
    private BigDecimal balance;
    
   
    private User user;
    
  
 	private List<Transaction> listTransaction;

   
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	

	public Account(int id, String accountType, BigDecimal balance, User user) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.balance = balance;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountType=" + accountType + ", balance=" + balance + "]";
	}
	
	public Account() {}
    
    
    
}

