package com.pedro.jijidoces.dtos.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.pedro.jijidoces.dtos.orderItem.OrderItemResponseDTO;
import com.pedro.jijidoces.enums.OrderStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class OrderResponseDTO {
	@Schema(description = "Order id", example = "1")
    private Long id;
	@Schema(description = "Client name", example = "Pedro")
    private String clientName;
	@Schema(description = "Order delivery date and time", example = "2026-05-25T14:00:00")
    private LocalDateTime deliveryDate;
	@Schema(description = "Order creation date and time", example = "2026-05-25T11:26:17")
    private LocalDateTime createdAt;
	@Schema(description = "Order status", example = "EM_PRODUCAO")
    private OrderStatus status;
	@Schema(description = "Total order price", example = "45.00")
    private BigDecimal totalPrice;	
	@Schema(description = "Order items")
    private List<OrderItemResponseDTO> items;
}
