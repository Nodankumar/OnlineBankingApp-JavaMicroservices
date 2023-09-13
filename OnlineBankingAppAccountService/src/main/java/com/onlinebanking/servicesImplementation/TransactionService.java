package com.onlinebanking.servicesImplementation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.models.Account;
import com.onlinebanking.models.Transaction;
import com.onlinebanking.repositories.AccountRepository;
import com.onlinebanking.repositories.TransactionRepository;
import com.onlinebanking.services.iTransactionService;

@Service
public class TransactionService implements iTransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Transaction> getAllTransaction() {
	return transactionRepository.findAll();
	}

	  public Transaction getById(int id) {
	        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
	        return transactionOptional.orElse(null);
	    }

	
	 public Transaction insertTransaction(Transaction transaction) {
	        Optional<Account> source = accountRepository.findById(transaction.getAccount().getId());
	        Optional<Account> destination = accountRepository.findById(Integer.parseInt(transaction.getDestinationAccountId()));

	        if (source.isPresent() && destination.isPresent()) {
	            Account sourceAccount = source.get();
	            Account destinationAccount = destination.get();

	            BigDecimal currentBalanceSource = sourceAccount.getBalance();
	            BigDecimal transactionAmount = transaction.getAmount();

	            if (currentBalanceSource.compareTo(transactionAmount) >= 0) {
	                BigDecimal newBalanceSource = currentBalanceSource.subtract(transactionAmount);
	                sourceAccount.setBalance(newBalanceSource);
	                accountRepository.save(sourceAccount);

	                BigDecimal currentBalanceDestination = destinationAccount.getBalance();
	                BigDecimal newBalanceDestination = currentBalanceDestination.add(transactionAmount);
	                destinationAccount.setBalance(newBalanceDestination);
	                accountRepository.save(destinationAccount);

	                LocalDate currentDate = LocalDate.now();
	                LocalTime currentTime = LocalTime.now();
	                transaction.setDate(currentDate);
	                transaction.setTime(currentTime);

	                return transactionRepository.save(transaction);
	            } else {
	               return null;
	            }
	        } else {
	           return null;
	        }
	    }
	 
	 
	


	@Override
	public List<Transaction> findBydestinationAccountId(String destinationAccountId) {
		return transactionRepository.findBydestinationAccountId(destinationAccountId);
	}

	@Override
	public List<Transaction> findByAccountId(int id) {
		return transactionRepository.findByAccountId(id);
	}

	

}
