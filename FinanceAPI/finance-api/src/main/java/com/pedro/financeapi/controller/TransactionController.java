package com.pedro.financeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.financeapi.dto.transaction.TransactionRequestDTO;
import com.pedro.financeapi.dto.transaction.TransactionResponseDTO;
import com.pedro.financeapi.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	//create transaction:
	@PostMapping
	public ResponseEntity<TransactionResponseDTO> createTransaction(@Valid @RequestBody TransactionRequestDTO request){
		TransactionResponseDTO response = transactionService.createTransaction(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	//get all transactions:
	@GetMapping
	public ResponseEntity<List<TransactionResponseDTO>> getAllTransactions(){
		List<TransactionResponseDTO> responseList = transactionService.getAllTransactions();
		return ResponseEntity.status(HttpStatus.OK).body(responseList);
	}
	
	//get transaction by id:
	@GetMapping("/{id}")
	public ResponseEntity<TransactionResponseDTO> getTransactionById(@PathVariable Long id){
		TransactionResponseDTO response = transactionService.getTransactionById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//update user:
	@PutMapping("{id}")
	public ResponseEntity<TransactionResponseDTO> updateTransaction(@PathVariable Long id, @Valid @RequestBody TransactionRequestDTO request){
		TransactionResponseDTO response = transactionService.updateTransaction(id, request);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//delete transaction:
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
		transactionService.deleteTransaction(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	
	
	
	
}
