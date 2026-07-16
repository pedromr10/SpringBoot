package com.pedro.financeapi.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.pedro.financeapi.enums.TransactionType;

import lombok.Data;

@Data
public class TransactionResponseDTO {
	private Long id;
	private String description;
	private BigDecimal amount;
	private TransactionType type;
	private LocalDate date;
	private Long userId;
}
