package com.pedro.jijidoces.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.jijidoces.dtos.order.OrderRequestDTO;
import com.pedro.jijidoces.dtos.order.OrderResponseDTO;
import com.pedro.jijidoces.entities.Order;
import com.pedro.jijidoces.exceptions.OrderNotFoundException;
import com.pedro.jijidoces.mappers.OrderMapper;
import com.pedro.jijidoces.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	// add order:
	public OrderResponseDTO addOrder(OrderRequestDTO request) {
		Order order = OrderMapper.toEntity(request);
		Order savedOrder = orderRepo.save(order);
		return OrderMapper.toResponse(savedOrder);
	}

	// get order by id:
	public OrderResponseDTO getOrderById(Long id) {
		Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException("Pedido nao encontrado"));
		return OrderMapper.toResponse(order);
	}

	// get all orders:
	public List<OrderResponseDTO> getAllOrders() {
		List<Order> list = orderRepo.findAll();
		return list.stream().map(OrderMapper::toResponse).toList();
	}

	// delete order:
	public void deleteOrder(Long id) {
		Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException("Pedido nao encontrado"));
		orderRepo.delete(order);
	}

	// update order:
	public OrderResponseDTO updateOrder(Long id, OrderRequestDTO request) {
		Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException("Pedido nao encontrado"));
		order.setClientName(request.getClientName());
		order.setDeliveryDate(request.getDeliveryDate());
		order.setStatus(request.getStatus());
		Order updatedOrder = orderRepo.save(order);
		return OrderMapper.toResponse(updatedOrder);
	}
}
