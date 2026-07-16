package com.pedro.financeapi.mapper;

import org.springframework.stereotype.Component;

import com.pedro.financeapi.dto.transaction.TransactionRequestDTO;
import com.pedro.financeapi.dto.transaction.TransactionResponseDTO;
import com.pedro.financeapi.entity.Transaction;
import com.pedro.financeapi.entity.User;

@Component
public class TransactionMapper {
	
	//dto to entity:
	public Transaction toEntity(TransactionRequestDTO dto, User user) {
		Transaction transaction = new Transaction();
		transaction.setDescription(dto.getDescription());
		transaction.setAmount(dto.getAmount());
		transaction.setType(dto.getType());
		transaction.setDate(dto.getDate());
		transaction.setUser(user);
		
		return transaction;
	}
	
	//entity to dto:
	public TransactionResponseDTO toResponse(Transaction transaction) {
		TransactionResponseDTO response = new TransactionResponseDTO();
		response.setId(transaction.getId());
		response.setDescription(transaction.getDescription());
		response.setAmount(transaction.getAmount());
		response.setType(transaction.getType());
		response.setDate(transaction.getDate());
		response.setUserId(transaction.getUser().getId());
		
		return response;
	}
	
	
}
