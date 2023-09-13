package com.onlinebanking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebanking.models.Transaction;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> findBydestinationAccountId(String destinationAccountId);
	
	List<Transaction> findByAccountId(int id);
	
}
