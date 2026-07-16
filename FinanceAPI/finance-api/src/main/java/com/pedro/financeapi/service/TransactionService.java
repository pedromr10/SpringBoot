package com.pedro.financeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.financeapi.dto.transaction.TransactionRequestDTO;
import com.pedro.financeapi.dto.transaction.TransactionResponseDTO;
import com.pedro.financeapi.entity.Transaction;
import com.pedro.financeapi.entity.User;
import com.pedro.financeapi.exception.UserNotFoundException;
import com.pedro.financeapi.mapper.TransactionMapper;
import com.pedro.financeapi.repository.TransactionRepository;
import com.pedro.financeapi.repository.UserRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionMapper mapper;
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	//create transaction:
	public TransactionResponseDTO createTransaction(TransactionRequestDTO request) {
		User user = userRepo.findById(request.getUserId()).orElseThrow(() -> new UserNotFoundException(request.getUserId()));
		
		Transaction transaction = mapper.toEntity(request, user);
		Transaction savedTransaction = transactionRepo.save(transaction);
		
		return mapper.toResponse(savedTransaction);
		
	}
	
	//get all transactions:
	public List<TransactionResponseDTO> getAllTransactions(){
		return transactionRepo.findAll().stream().map(mapper::toResponse).toList();
	}
	
	//get transaction by id:
	public TransactionResponseDTO getTransactionById(Long id) {
		Transaction transaction = transactionRepo.findById(id).orElseThrow(()-> newTransactionNotFoundException(id));
		
		return mapper.toResponse(transaction);
	}

	
	
	
	
}





