package com.onlinestore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.dtos.OrderResponseDto;
import com.onlinestore.entities.Order;
import com.onlinestore.exceptions.OrderNotFoundException;
import com.onlinestore.mappers.OrderMapper;
import com.onlinestore.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderMapper orderMapper;
	
	//list all orders:
	public List<OrderResponseDto> findAll(){
		return orderRepo.findAll().stream().map(orderMapper::toResponse).toList();
	}
	
	//search order by id:
	public OrderResponseDto findById(Long id) {
		Order order = orderRepo.findById(id).orElseThrow(()-> new OrderNotFoundException("Order not found"));
		return orderMapper.toResponse(order);
	}
}
