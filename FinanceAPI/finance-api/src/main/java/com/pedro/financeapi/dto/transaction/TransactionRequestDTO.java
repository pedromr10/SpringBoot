package com.pedro.financeapi.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.pedro.financeapi.enums.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransactionRequestDTO {
	@NotBlank(message = "Description is required")
	private String description;
	@NotNull(message = "Amount is required")
	private BigDecimal amount;
	@NotNull(message = "Transaction type is required")
	private TransactionType type;
	@NotNull(message = "Transaction date is required")
	private LocalDate date;
	@NotNull(message = "User id is required")
	private Long userId;
}
