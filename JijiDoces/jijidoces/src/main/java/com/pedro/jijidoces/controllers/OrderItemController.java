package com.pedro.jijidoces.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.jijidoces.dtos.orderItem.OrderItemRequestDTO;
import com.pedro.jijidoces.dtos.orderItem.OrderItemResponseDTO;
import com.pedro.jijidoces.services.OrderItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders/{orderId}/items")
public class OrderItemController {
	
	@Autowired
	private OrderItemService oiService;
	
	// add item to order:
	@PostMapping
	public ResponseEntity<OrderItemResponseDTO> addItemToOrder(@PathVariable Long orderId, @RequestBody @Valid OrderItemRequestDTO request){
		OrderItemResponseDTO response = oiService.addItemToOrder(orderId, request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	// find items from orderid:
	@GetMapping
	public ResponseEntity<List<OrderItemResponseDTO>> getItemsByOrderId(@PathVariable Long orderId){
		List<OrderItemResponseDTO> response = oiService.getItemsByOrderId(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	// delete items:
	@DeleteMapping("/{orderItemId}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long orderItemId){
		oiService.deleteItem(orderItemId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
