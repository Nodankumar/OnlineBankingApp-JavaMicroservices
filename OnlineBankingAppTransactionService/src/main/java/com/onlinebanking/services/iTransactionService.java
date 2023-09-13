package com.onlinebanking.services;

import java.util.List;

import com.onlinebanking.models.Transaction;

public interface iTransactionService {
	
	public List<Transaction> getAllTransaction();
	public Transaction getById(int id);
	public  Transaction insertTransaction(Transaction transaction);
	public List<Transaction> findBydestinationAccountId(String destinationAccountId);
	public List<Transaction> findByAccountId(int id);
	






	
}
