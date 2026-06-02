package com.pedro.jijidoces.dtos.order;

import java.time.LocalDateTime;

import com.pedro.jijidoces.enums.OrderStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderRequestDTO {
	@Schema(description = "Client name", example = "Pedro")
	@NotBlank
	private String clientName;
	@Schema(description = "Order delivery date and time", example = "2026-05-25T14:00:00")
	@NotNull
	private LocalDateTime deliveryDate;
	@Schema(description = "Order status", example = "EM_PRODUCAO")
	@NotNull
	private OrderStatus status;
}
