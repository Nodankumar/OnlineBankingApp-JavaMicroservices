package com.onlinebanking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity

public class ChequeBook {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String accountType;
    private String description;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
   
   
	public ChequeBook(Long id, String accountType, String description, Account account) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.description = description;
		this.account = account;
		

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	public ChequeBook() {
	    // Default constructor with no arguments
	}

}
    
     

