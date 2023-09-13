package com.withdraw.entity;

import java.math.BigDecimal;






public class Transaction {
	




	private int id;
	private String sourceAccountId;
	private String destinationAccountId;
	private String description;
	private BigDecimal amount;
	
	   


    private Account account;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSourceAccountId() {
		return sourceAccountId;
	}
	public void setSourceAccountId(String sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}
	public String getDestinationAccountId() {
		return destinationAccountId;
	}
	public void setDestinationAccountId(String destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	public Transaction(String sourceAccountId, String destinationAccountId, String description, BigDecimal amount,
			Account account, int accountId) {
		super();
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
		this.description = description;
		this.amount = amount;
		this.account = account;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", sourceAccountId=" + sourceAccountId + ", destinationAccountId="
				+ destinationAccountId + ", description=" + description + ", amount=" + amount + ",]";
	}
	
	public  Transaction() {
	}
	
}
