package com.pedro.jijidoces.dtos.order;

import java.time.LocalDateTime;

import com.pedro.jijidoces.enums.OrderStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderRequestDTO {
	@NotBlank
	private String clientName;
	@NotNull
	private LocalDateTime deliveryDate;
	@NotNull
	private OrderStatus status;
}
