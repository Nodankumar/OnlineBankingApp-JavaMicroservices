package com.onlinebanking.servicesImplementation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.onlinebanking.models.Account;
import com.onlinebanking.repositories.AccountRepository;
import com.onlinebanking.services.iAccountService;

@Service(value="AccountService")
@Scope(value="singleton")
public class AccountService implements iAccountService {

    @Autowired
    @Qualifier(value="AccountRepository")
    AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public Account getByIdAccount(int id) {
	    Optional<Account> accountOptional = accountRepository.findById(id);
	    return accountOptional.orElse(null);
	}


	@Override
	public Account CreateAccount(Account account) {
		Account accounts  = accountRepository.save(account);
		return accounts;
	}

	@Override
	public Account depositAmount(int id, BigDecimal amount) {
	    Optional<Account> accountOptional = accountRepository.findById(id);
	    
	    if (accountOptional.isPresent()) {
	        Account accountDetails = accountOptional.get();
	        BigDecimal currentBalance = accountDetails.getBalance();
	        BigDecimal newBalance = currentBalance.add(amount);
	        accountDetails.setBalance(newBalance);

	        accountRepository.save(accountDetails);
	        
	        System.out.println("Deposited: " + amount);
	        System.out.println("New Balance: " + newBalance);
	        return accountDetails;
	    } else {
	        System.out.println("Account not found");
	      
	    }
		return null;
	  
	}

	@Override
	public Account WithdrawAmount(int id, BigDecimal amount) {
		Optional<Account> accountOptional = accountRepository.findById(id);
	    
	    if (accountOptional.isPresent()) {
	        Account accountDetails = accountOptional.get();
	        BigDecimal currentBalance = accountDetails.getBalance();
	        BigDecimal newBalance = currentBalance.subtract(amount);
	        accountDetails.setBalance(newBalance);

	        accountRepository.save(accountDetails);
	        
	        System.out.println("WithDraw: " + amount);
	        System.out.println("New Balance: " + newBalance);
	        return accountDetails;
	    } else {
	        System.out.println("Account not found");
	      
	    }
		return null;
	}

	
	
	

  
}

