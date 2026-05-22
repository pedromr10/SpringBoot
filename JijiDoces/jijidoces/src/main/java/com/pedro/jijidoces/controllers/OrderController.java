package com.pedro.jijidoces.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.jijidoces.dtos.order.OrderRequestDTO;
import com.pedro.jijidoces.dtos.order.OrderResponseDTO;
import com.pedro.jijidoces.services.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//add order:
	@PostMapping
	public ResponseEntity<OrderResponseDTO> addOrder(@RequestBody @Valid OrderRequestDTO request){
		OrderResponseDTO response = orderService.addOrder(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	//get order by id
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id){
		OrderResponseDTO response = orderService.getOrderById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//get all orders:
	@GetMapping
	public ResponseEntity<List<OrderResponseDTO>> getAllOrders(){
		List<OrderResponseDTO> list = orderService.getAllOrders();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	//delete order:
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
		orderService.deleteOrder(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//update order:
	@PutMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderRequestDTO request){
		OrderResponseDTO response = orderService.updateOrder(id, request);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}




