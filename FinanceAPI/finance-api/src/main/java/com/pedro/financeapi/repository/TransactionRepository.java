package com.pedro.financeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.financeapi.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
}
