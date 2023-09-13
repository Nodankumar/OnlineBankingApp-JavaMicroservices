package com.onlinebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.models.Transaction;
import com.onlinebanking.servicesImplementation.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping(path="getAllTransactions",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getAlltransaction(){
		return transactionService.getAllTransaction();
	}
	
	@GetMapping(path="transaction/{destinationAccountId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getdestinationAccountId(@PathVariable String destinationAccountId){
		return transactionService.findBydestinationAccountId(destinationAccountId);
	}
	
	@PostMapping(path="send",produces = MediaType.APPLICATION_JSON_VALUE)
	public Transaction insertTransaction(@RequestBody Transaction transaction){
		return transactionService.insertTransaction(transaction);
}
	
	@GetMapping(path="getTransaction/account/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getAccountId(@PathVariable int id) {
		return transactionService.findByAccountId(id);
	}



	
	@GetMapping(path="getTransactionById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Transaction getTransactionByid(@PathVariable int id) {
		return transactionService.getById(id);
	}
	
	
}
