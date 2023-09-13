package com.example.TransactionFeignResilience4jRetrySZ.proxy;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.TransactionFeignResilience4jRetrySZ.entity.Account;
import com.example.TransactionFeignResilience4jRetrySZ.entity.Transaction;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "transaction-service")
public interface TransactionProxy {

    @Retry(name = "transaction-service")
    @CircuitBreaker(name = "transaction-service", fallbackMethod = "fallbackAlltransaction")
    @GetMapping("getAllTransactions")
    List<Transaction> getAlltransaction();

    @Retry(name = "transaction-service")
    @CircuitBreaker(name = "transaction-service", fallbackMethod = "fallbackfordestinationAccountId")
    @GetMapping("transaction/{destinationAccountId}")
    List<Transaction> getdestinationAccountId(@PathVariable String destinationAccountId);

    @Retry(name = "transaction-service")
    @CircuitBreaker(name = "transaction-service", fallbackMethod = "fallbackforinsertTransaction")
    @PostMapping("send")
    public Transaction insertTransaction(@RequestBody Transaction transaction);
    
    @Retry(name = "transaction-service")
    @CircuitBreaker(name = "transaction-service", fallbackMethod = "fallbackgetAccountByidTransaction")
	@GetMapping(path="getTransaction/account/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getAccountId(@PathVariable int id);

    @Retry(name = "transaction-service")
    @CircuitBreaker(name = "transaction-service", fallbackMethod = "fallbackTransactionByid")
    @GetMapping("getTransactionById/{id}")
    Transaction getTransactionByid(@PathVariable int id);

    default List<Transaction> fallbackAlltransaction(Throwable cause) {
        System.out.println("Exception raised due to " + cause.getMessage());
        System.err.println("Fall in Fallback method");
        return Collections.emptyList();
    }

    default List<Transaction> fallbackfordestinationAccountId(Throwable cause) {
        System.out.println("Exception raised due to " + cause.getMessage());
        System.err.println("Fallen Fallback method");
        return Collections.emptyList();
    }

    default List<Transaction>fallbackgetAccountByidTransaction(Throwable cause) {
        System.out.println("Exception raised due to " + cause.getMessage());
        System.err.println("Falls in Fallback method");
        return Collections.emptyList();
    }

    default Transaction fallbackforinsertTransaction(Transaction transaction, Throwable cause) {
        System.out.println("Exception raised due to " + cause.getMessage());
        System.err.println("failed");
        Account account = new Account(0, "Savings", new BigDecimal("200"));
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        return new Transaction(0, "0", "Payment for services", date, time, new BigDecimal("200"), account);
    }

    default Transaction fallbackTransactionByid(int id, Throwable cause) {
        System.out.println("Exception raised due to " + cause.getMessage());
        System.err.println("failed to transfer money");
        Account account = new Account(0, "Savings", new BigDecimal("200"));
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        return new Transaction(0, "0", "Payment for services", date, time, new BigDecimal("200"), account);
    }
}
