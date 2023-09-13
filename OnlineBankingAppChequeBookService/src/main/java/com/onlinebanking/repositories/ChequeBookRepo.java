package com.onlinebanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebanking.models.ChequeBook;

@Repository
public interface ChequeBookRepo extends JpaRepository<ChequeBook, Long> {
	
}
