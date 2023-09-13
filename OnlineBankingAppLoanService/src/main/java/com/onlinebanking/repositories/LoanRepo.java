package com.onlinebanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinebanking.models.Loan;


public interface LoanRepo extends JpaRepository<Loan,Long> {

}
