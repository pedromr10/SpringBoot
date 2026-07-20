package com.pedro.financeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.financeapi.dto.transaction.TransactionRequestDTO;
import com.pedro.financeapi.dto.transaction.TransactionResponseDTO;
import com.pedro.financeapi.entity.Transaction;
import com.pedro.financeapi.entity.User;
import com.pedro.financeapi.exception.TransactionNotFoundException;
import com.pedro.financeapi.exception.UserNotFoundException;
import com.pedro.financeapi.mapper.TransactionMapper;
import com.pedro.financeapi.repository.TransactionRepository;
import com.pedro.financeapi.repository.UserRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionMapper transactionMapper;
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	//create transaction:
	public TransactionResponseDTO createTransaction(TransactionRequestDTO request) {
		User user = userRepo.findById(request.getUserId()).orElseThrow(() -> new UserNotFoundException(request.getUserId()));
		
		Transaction transaction = transactionMapper.toEntity(request, user);
		Transaction savedTransaction = transactionRepo.save(transaction);
		
		return transactionMapper.toResponse(savedTransaction);
		
	}
	
	//get all transactions:
	public List<TransactionResponseDTO> getAllTransactions(){
		return transactionRepo.findAll().stream().map(transactionMapper::toResponse).toList();
	}
	
	//get transaction by id:
	public TransactionResponseDTO getTransactionById(Long id) {
		Transaction transaction = transactionRepo.findById(id).orElseThrow(()-> new TransactionNotFoundException(id));
		
		return transactionMapper.toResponse(transaction);
	}

	//update transaction:
	public TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO request) {
		
		User user = userRepo.findById(request.getUserId()).orElseThrow(()-> new UserNotFoundException(request.getUserId()));
		
		Transaction transaction = transactionRepo.findById(id).orElseThrow(()-> new TransactionNotFoundException(id));
		transaction.setDescription(request.getDescription());
		transaction.setAmount(request.getAmount());
		transaction.setDate(request.getDate());
		transaction.setType(request.getType());
		transaction.setUser(user);
		
		Transaction savedTransaction = transactionRepo.save(transaction);
		return transactionMapper.toResponse(savedTransaction);
		
	}
	
	//delete transaction:
	public void deleteTransaction(Long id) {
		Transaction transaction = transactionRepo.findById(id).orElseThrow(()-> new TransactionNotFoundException(id));
		transactionRepo.delete(transaction);
	}
	
	//get transactions by user id:
	public List<TransactionResponseDTO> getTransactionsByUserId(Long userId){
		User user = userRepo.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
		return transactionRepo.findByUserId(userId).stream().map(transactionMapper::toResponse).toList();
	}
	
}





