package com.onlinebanking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.models.ChequeBook;
import com.onlinebanking.servicesImplementation.ChequeBookService;


@RestController

public class ChequeBookController {
	@Autowired
	private ChequeBookService chequebookService;

	
    @GetMapping("/getAllCheckbooks")
    public List<ChequeBook> getAllChequebooks() {
        return chequebookService.getAllChequebooks();
    }
    @PostMapping("/createCheckbook")
    @ResponseStatus(HttpStatus.CREATED)
    public ChequeBook createChequebook(@RequestBody ChequeBook chequebook) {
        return chequebookService.createchequeBook(chequebook);
    }
    
    @GetMapping("getCheckbookbyId/{id}")
    public ResponseEntity<ChequeBook> getChequeBookById(@PathVariable Long id) {
        Optional<ChequeBook> chequeBook = chequebookService.getChequeBookById(id);
        if (chequeBook.isPresent()) {
            return ResponseEntity.ok(chequeBook.get());
        } else {
        	System.out.println("Cheque Book with ID " + id + " not found.");
            return ResponseEntity.notFound().build();
        }
    }
 

}
