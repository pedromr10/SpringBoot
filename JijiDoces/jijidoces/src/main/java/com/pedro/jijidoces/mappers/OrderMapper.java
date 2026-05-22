package com.pedro.jijidoces.mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.pedro.jijidoces.dtos.order.OrderRequestDTO;
import com.pedro.jijidoces.dtos.order.OrderResponseDTO;
import com.pedro.jijidoces.entities.Order;

public class OrderMapper {
	public static Order toEntity(OrderRequestDTO dto) {
		return Order.builder().clientName(dto.getClientName()).deliveryDate(dto.getDeliveryDate())
				.createdAt(LocalDateTime.now()).status(dto.getStatus()).totalPrice(BigDecimal.ZERO).build();
	}

	public static OrderResponseDTO toResponse(Order order) {
		return OrderResponseDTO.builder().id(order.getId()).clientName(order.getClientName())
				.deliveryDate(order.getDeliveryDate()).createdAt(order.getCreatedAt()).status(order.getStatus())
				.totalPrice(order.getTotalPrice()).build();
	}
}
