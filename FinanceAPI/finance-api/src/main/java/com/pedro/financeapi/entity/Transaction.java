package com.pedro.financeapi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.pedro.financeapi.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "transactions")
public class Transaction {
	private Long id;
	private String description;
	private BigDecimal amount;
	private TransactionType type;
	private LocalDate date;
	@ManyToOne
	private User user;
}
