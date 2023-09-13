package com.onlinebanking.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.entities.ChequeBook;
import com.onlinebanking.proxy.ChequeBookServiceProxy;


@RestController
public class ChequeBookClientController {

	@Autowired
	private ChequeBookServiceProxy chequeBookServiceProxy;

	private Logger log = LoggerFactory.getLogger(ChequeBookClientController.class);

	@GetMapping("/getallCheckbooks")
	public List<ChequeBook> getAllChequebooks() {
		
		List<ChequeBook> chequebooks = chequeBookServiceProxy.getAllChequebooks();
		log.debug("In getAllChequebooks with return value ChequeBooks: " + chequebooks);
		return chequebooks;
	}


	@GetMapping("getCheckbookbyId/{id}")
	public ResponseEntity<ChequeBook> getChequeBookById(@PathVariable("id") Long id) {
		
		log.debug("In getChequeBookById with Id: " + id);
		Optional<ChequeBook> chequeBook = chequeBookServiceProxy.getChequeBookById(id);
		if (chequeBook.isPresent()) {
			log.debug("In getChequeBookById with return value if ChequeBook is present : " + chequeBook);
			return ResponseEntity.ok(chequeBook.get());
		} else {
			log.debug("In getChequeBookById with return value if ChequeBook is not present: " + chequeBook);
			System.out.println("Cheque Book with ID " + id + " not found.");
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	 @PostMapping("/createCheckbook")
	    @ResponseStatus(HttpStatus.CREATED)
	    public ChequeBook createChequebook(@RequestBody ChequeBook chequebook) {
		 log.debug("In createChequebook, chequebook created is: " + chequebook);
	        return chequeBookServiceProxy.createChequebook(chequebook);
	    }
	 
		 
	}


