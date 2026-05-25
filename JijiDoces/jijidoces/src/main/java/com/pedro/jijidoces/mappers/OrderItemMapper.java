package com.pedro.jijidoces.mappers;

import java.math.BigDecimal;

import com.pedro.jijidoces.dtos.orderItem.OrderItemRequestDTO;
import com.pedro.jijidoces.dtos.orderItem.OrderItemResponseDTO;
import com.pedro.jijidoces.entities.Order;
import com.pedro.jijidoces.entities.OrderItem;
import com.pedro.jijidoces.entities.Product;

public class OrderItemMapper {

	public static OrderItem toEntity(OrderItemRequestDTO dto, Order order, Product product) {
		BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(dto.getQuantity()));
		return OrderItem.builder().order(order).product(product).quantity(dto.getQuantity()).subtotal(subtotal).build();
	}

	public static OrderItemResponseDTO toResponse(OrderItem orderItem) {

		return OrderItemResponseDTO.builder().id(orderItem.getId()).orderId(orderItem.getOrder().getId())
				.productId(orderItem.getProduct().getId()).productFlavour(orderItem.getProduct().getFlavour())
				.quantity(orderItem.getQuantity()).unitPrice(orderItem.getProduct().getPrice())
				.subtotal(orderItem.getSubtotal()).build();
	}
}
