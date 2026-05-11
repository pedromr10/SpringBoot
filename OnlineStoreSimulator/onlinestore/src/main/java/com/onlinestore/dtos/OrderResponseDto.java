package com.onlinestore.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.onlinestore.entities.OrderItem;
import com.onlinestore.enums.OrderStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "Order data returned by the API")
public class OrderResponseDto {
	@Schema(description = "Order ID", example = "1")
	private Long id;
	@Schema(description = "Total order price", example = "459.90")
	private BigDecimal totalPrice;
	@Schema(description = "Order creation date")
	private LocalDateTime createdAt;
	@Schema(description = "Order status", example = "PENDING")
	private OrderStatus status;
	@Schema(description = "List of order items")
	private List<OrderItem> items = new ArrayList<>();
	
}
