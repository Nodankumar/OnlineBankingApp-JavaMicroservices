package com.onlinebanking.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlinebanking.entities.ChequeBook;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "chequebook-service")
public interface ChequeBookServiceProxy {

	
	
	@Retry(name = "chequebook-service")
	@CircuitBreaker(name = "chequebook-service", fallbackMethod = "fallbackMethodGetAllChequebooks")
	@GetMapping("/getAllCheckbooks")
	public List<ChequeBook> getAllChequebooks();
	
	
	@Retry(name = "chequebook-service")
	@CircuitBreaker(name = "chequebook-service", fallbackMethod = "fallbackMethodGetChequeBookById")
	@GetMapping("getCheckbookbyId/{id}")
	public Optional<ChequeBook> getChequeBookById(@PathVariable("id") Long id);
	
	
	@Retry(name = "chequebook-service")
	@CircuitBreaker(name = "chequebook-service", fallbackMethod = "fallbackMethodCreateChequebook")
	@PostMapping("/createCheckbook")
	public ChequeBook createChequebook(ChequeBook chequebook);
	
	
	// Fallback Methods
	
	public default List<ChequeBook> fallbackMethodGetAllChequebooks(Throwable cause) {
		
		System.out.println("Exception Raised with Message: ---> " + cause.getMessage());
		System.err.println("Fallback: Error occurred .");
		return new ArrayList<ChequeBook>();
	}
	
	
	public default Optional<ChequeBook> fallbackMethodGetChequeBookById(Long id, Throwable cause) {
		
		System.out.println("Exception Raised with Message: ---> " + cause.getMessage());
		System.err.println("Fallback: Error occurred while searching for the chequebook with id.");
		 
		// Cheque Book
		ChequeBook chequebook = new ChequeBook();
		chequebook.setId(id);
		chequebook.setAccountType("default account type");
		chequebook.setDescription("default description");
		 return Optional.of(chequebook);
		// setAccount, setUser

		 

	}
	
	
	public default ChequeBook fallbackMethodCreateChequebook(ChequeBook chequebook, Throwable cause) {
		
		System.out.println("Exception Raised with Message: ---> " + cause.getMessage());
		System.err.println("Fallback : Request to createChequebook is failed.");
		return null;
        
	}
	
	
	 
	
	
}
