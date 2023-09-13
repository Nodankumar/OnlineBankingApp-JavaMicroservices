package com.dynamicDiscovery.proxies;

import java.util.List;
import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.dynamicDiscovery.entities.User;
import com.dynamicDiscovery.entities.Loan;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "loan-service")
public interface LoanServiceProxy {

    @Retry(name = "loan-service")
    @CircuitBreaker(name = "loan-service", fallbackMethod = "fallbackMethodGetAllLoans")
    @GetMapping("/getAllLoans")
    List<Loan> AllLoans();

    @Retry(name = "loan-service")
    @CircuitBreaker(name = "loan-service", fallbackMethod = "fallbackMethodGetLoanById")
    @GetMapping("/getLoan/{id}")
    Loan findLoanById(@PathVariable("id") long id);

    @Retry(name = "loan-service")
    @CircuitBreaker(name = "loan-service", fallbackMethod = "fallbackMethodCreateLoan")
    @PostMapping("/createLoan")
    Loan createLoan(@RequestBody Loan loan);

    @Retry(name = "loan-service")
    @CircuitBreaker(name = "loan-service", fallbackMethod = "fallbackMethodLoanRequestTrue")
    @GetMapping("/admin/confirmLoanTrue/{id}")
    boolean LoanRequestTrue(@PathVariable("id") long id);

    @Retry(name = "loan-service")
    @CircuitBreaker(name = "loan-service", fallbackMethod = "fallbackMethodLoanRequestFalse")
    @GetMapping("/admin/confirmLoanFalse/{id}")
    boolean LoanRequestFalse(@PathVariable("id") long id);

    default Loan fallbackMethodGetLoanById(long id, Throwable cause) {
        System.out.println("Exception raised with message: " + cause.getMessage());
        User user = new User(1, "mahi", "mahesh", "87836378", "mahesh@gmail.com", "mahesh12", "hdg");
        return new Loan(id, true, "Home loan", user);
    }

    default List<Loan> fallbackMethodGetAllLoans(Throwable cause) {
        System.out.println("Exception raised with message: " + cause.getMessage());
        return new ArrayList<>();
    }

    default Loan fallbackMethodCreateLoan(Throwable cause) {
        System.out.println("Exception raised with message: " + cause.getMessage());
        User user = new User(1, "mahi", "mahesh", "87836378", "mahesh@gmail.com", "mahesh12", "hdg");
        return new Loan(2L, true, "Home loan", user);
    }

    default boolean fallbackMethodLoanRequestTrue(long id, Throwable cause) {
        System.out.println("Exception raised with message: " + cause.getMessage());
     
        return false;
    }

    default boolean fallbackMethodLoanRequestFalse(long id, Throwable cause) {
        System.out.println("Exception raised with message: " + cause.getMessage());
        
        return false;
    }
}
