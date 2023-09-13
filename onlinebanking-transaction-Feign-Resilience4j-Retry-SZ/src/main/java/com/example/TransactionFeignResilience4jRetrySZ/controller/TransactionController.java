package com.example.TransactionFeignResilience4jRetrySZ.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TransactionFeignResilience4jRetrySZ.entity.Transaction;
import com.example.TransactionFeignResilience4jRetrySZ.proxy.TransactionProxy;

@RestController
public class TransactionController {

    @Autowired
    TransactionProxy transactionalProxy;
    
    private static Logger log = LoggerFactory.getLogger(TransactionController.class);

    @GetMapping("getAllTransactions")
    public List<Transaction> getAlltransaction() {
    	 List<Transaction>  transactions=  transactionalProxy.getAlltransaction();
    	 log.debug("In getAlltransactions with return value transactions: " + transactions);
        return transactions;
    }

    @GetMapping("transaction/{destinationAccountId}")
    public List<Transaction> getdestinationAccountId(@PathVariable String destinationAccountId) {
    	List<Transaction>  transactions=  transactionalProxy.getdestinationAccountId(destinationAccountId);
   	 log.debug("In getAlltransactions with return value transactions: " + transactions);
        return transactions;
    }

    @PostMapping(path="send",produces = MediaType.APPLICATION_JSON_VALUE)
	public Transaction insertTransaction(@RequestBody Transaction transaction){
    	Transaction transactions=transactionalProxy.insertTransaction(transaction);
    	log.debug("In newtransaction with return value:" + transactions);
		return transactions;
}



    @GetMapping("getTransactionById/{id}")
    public Transaction getTransactionByid(@PathVariable int id) {
    	Transaction transactions=transactionalProxy.getTransactionByid(id);
    	log.debug("In gettransactionbu id with return value:" + transactions);
        return transactions;
    }
   
    @GetMapping(path="getTransaction/account/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getAccountId(@PathVariable int id) {
		List<Transaction> transaction = transactionalProxy.getAccountId(id);
		log.debug("In getAccountId with return value:" + transaction);
		return transaction;
	}
}
