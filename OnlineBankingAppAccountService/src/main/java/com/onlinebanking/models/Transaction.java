package com.onlinebanking.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private int id;
	private String destinationAccountId;
	private String description;
	private LocalDate date;
	private LocalTime time;
	private BigDecimal amount;
	
	   
    @ManyToOne
    @JoinColumn(name="id") 
    private Account account;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	

	
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
	
	
	
	
	
	
	public Transaction(String destinationAccountId, String description, LocalDate date, LocalTime time,
			BigDecimal amount, Account account) {
		super();
		this.destinationAccountId = destinationAccountId;
		this.description = description;
		this.date = date;
		this.time = time;
		this.amount = amount;
		this.account = account;
	}
	
	
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", destinationAccountId=" + destinationAccountId + ", description="
				+ description + ", date=" + date + ", time=" + time + ", amount=" + amount + ", account=" + account
				+ "]";
	}
	public  Transaction() {
	}
	

}
