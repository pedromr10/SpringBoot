package com.onlinestore.mappers;

import org.springframework.stereotype.Component;

import com.onlinestore.dtos.OrderItemResponseDto;
import com.onlinestore.dtos.OrderResponseDto;
import com.onlinestore.entities.Order;
import com.onlinestore.entities.OrderItem;

@Component
public class OrderMapper {
	
	//entity to dto (order):
	public OrderResponseDto toResponse(Order order) {
		OrderResponseDto response = new OrderResponseDto();
		response.setId(order.getId());
		response.setTotalPrice(order.getTotalPrice());
		response.setStatus(order.getStatus());
		response.setCreatedAt(order.getCreatedAt());
		response.setItems(order.getItems().stream().map(this::toItemResponse).toList());
		return response;
	}
	
	//entity to dto (orderitem):
	public OrderItemResponseDto toItemResponse(OrderItem orderItem) {
		OrderItemResponseDto response = new OrderItemResponseDto();
		response.setProductName(orderItem.getProductName());
		response.setProductPrice(orderItem.getProductPrice());
		response.setQuantity(orderItem.getQuantity());
		response.setSubtotal(orderItem.getSubtotal());
		return response;
	}
}





