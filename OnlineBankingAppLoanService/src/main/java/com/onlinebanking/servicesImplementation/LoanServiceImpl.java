package com.onlinebanking.servicesImplementation;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.models.Loan;
import com.onlinebanking.repositories.LoanRepo;
import com.onlinebanking.services.LoanService;




@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanRepo loanrepo;

    @Override
    public Loan createLoan(Loan loan) {
        return loanrepo.save(loan);
    }

    @Override
    public List<Loan> AllLoans() {
        return loanrepo.findAll();
    }

    @Override
    public Loan findLoanById(long id) {
        Optional<Loan> optionalLoan = loanrepo.findById(id);
        return optionalLoan.orElse(null); 
    }

    @Override
    public boolean LoanRequestTrue(long id) {
        Optional<Loan> optionalLoan = loanrepo.findById(id);
        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            loan.setAccepted(true);
            loanrepo.save(loan);
            return true; 
        }
        return false; 
    }

    @Override
    public boolean LoanRequestFalse(long id) {
        Optional<Loan> optionalLoan = loanrepo.findById(id);
        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            loan.setAccepted(false);
            loanrepo.save(loan);
            return true; 
        }
        return false; 
    }
}
