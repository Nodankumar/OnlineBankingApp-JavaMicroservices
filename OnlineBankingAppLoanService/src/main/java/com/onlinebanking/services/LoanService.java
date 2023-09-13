package com.onlinebanking.services;

import java.util.List;

import com.onlinebanking.models.Loan;



public interface LoanService {
	public Loan createLoan(Loan Loan);
	public List<Loan> AllLoans();
	public Loan findLoanById(long id);
	public boolean LoanRequestTrue(long id);
	public boolean LoanRequestFalse(long id);
	

}