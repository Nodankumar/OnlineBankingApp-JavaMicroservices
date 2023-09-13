package com.onlinebanking.servicesImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebanking.models.ChequeBook;
import com.onlinebanking.repositories.ChequeBookRepo;


@Service
public class ChequeBookService {
	@Autowired
	private ChequeBookRepo chequeBookRepo;
	
	 
	
	public List<ChequeBook> getAllChequebooks() {
		return chequeBookRepo.findAll();
		
	}

	public ChequeBook createchequeBook(ChequeBook chequebook) {
		// TODO Auto-generated method stub
		return chequeBookRepo.save(chequebook);
	}

	public Optional<ChequeBook> getChequeBookById(Long id) {
		// TODO Auto-generated method stub
		return chequeBookRepo.findById(id);
	}
	
	

}
