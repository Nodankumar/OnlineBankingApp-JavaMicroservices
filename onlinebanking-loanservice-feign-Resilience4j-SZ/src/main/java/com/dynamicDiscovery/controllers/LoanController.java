package com.dynamicDiscovery.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.dynamicDiscovery.entities.Loan;
import com.dynamicDiscovery.proxies.LoanServiceProxy;

@RestController
public class LoanController {

    @Autowired
    private LoanServiceProxy loanServiceProxy;

    private Logger log = LoggerFactory.getLogger(LoanController.class);

    @GetMapping(value = "/getAllLoans", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Loan> getAllLoans() {
        List<Loan> loans = loanServiceProxy.AllLoans(); // Corrected method call
        log.debug("In getAllLoans with return value Loans: " + loans);
        return loans;
    }

    @GetMapping("getLoan/{loan_id}")
    public Loan getLoanById(@PathVariable int loan_id) {

        log.debug("In getLoanById with Id:" + loan_id);
        Loan loan = loanServiceProxy.findLoanById(loan_id); // Corrected method call
        log.debug("In getLoanById with return value Loan: " + loan);
        return loan;
    }

    @PostMapping("/createLoan")
    public Loan createLoan(@RequestBody Loan loan) {
        log.debug("In createLoan with Loan: " + loan);
        Loan createdLoan = loanServiceProxy.createLoan(loan);
        log.debug("In createLoan with return value Loan: " + createdLoan);
        return createdLoan;
    }

    @GetMapping("/admin/confirmLoanTrue/{id}")
    public boolean loanRequestTrue(@PathVariable("id") long id) {
        log.debug("In loanRequestTrue with Id: " + id);
        boolean result = loanServiceProxy.LoanRequestTrue(id);
        log.debug("In loanRequestTrue with return value: " + result);
        return result;
    }

    @GetMapping("/admin/confirmLoanFalse/{id}")
    public boolean loanRequestFalse(@PathVariable("id") long id) {
        log.debug("In loanRequestFalse with Id: " + id);
        boolean result = loanServiceProxy.LoanRequestFalse(id);
        log.debug("In loanRequestFalse with return value: " + result);
        return result;
    }
}
