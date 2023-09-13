package com.example.TransactionFeignResilience4jRetrySZ.entity;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;




public class Account {

  
    private int id;
    private String accountType;
    private BigDecimal balance;

    
    @OneToMany(mappedBy="account",cascade = CascadeType.REMOVE)
 	private List<Transaction> listTransaction;

   
 
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
	
	

	public Account(int id, String accountType, BigDecimal balance) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountType=" + accountType + ", balance=" + balance + "]";
	}
	
	public Account() {}
    
    
    
}

