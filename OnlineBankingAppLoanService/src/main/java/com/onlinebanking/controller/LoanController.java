package com.onlinebanking.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.onlinebanking.models.Loan;
import com.onlinebanking.services.LoanService;

@RestController
public class LoanController {
    
    @Autowired
    LoanService service;

    @PostMapping("/createLoan")
    public Loan createLoan(@RequestBody Loan loan) {
        System.out.println(loan);
        return service.createLoan(loan);
    }

    @GetMapping("/getAllLoans")
    public List<Loan> AllLoans() {
        return service.AllLoans();
    }

    @GetMapping("/getLoan/{id}")
    public Loan findLoanById(@PathVariable("id") Long id) { // Change parameter type to Long
        return service.findLoanById(id);
    }

    @GetMapping("/admin/confirmLoanTrue/{id}")
    public boolean LoanRequestTrue(@PathVariable("id") Long id) { // Change parameter type to Long
        return service.LoanRequestTrue(id);

    }

    @GetMapping("/admin/confirmLoanFalse/{id}")
    public boolean LoanRequestFalse(@PathVariable("id") Long id) { // Change parameter type to Long
        return service.LoanRequestFalse(id);
    }
}
