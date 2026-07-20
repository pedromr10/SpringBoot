package com.pedro.financeapi.dto.balance;

import java.math.BigDecimal;

import lombok.Data;


@Data
public class BalanceResponseDTO {
	private Long userId;
	private BigDecimal balance;
}
