package com.pedro.financeapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.financeapi.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	List<Transaction> findByUserId(Long userId);
}
