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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Order Items")
@RestController
@RequestMapping("/api/v1/orders/{orderId}/items")
public class OrderItemController {
	
	@Autowired
	private OrderItemService oiService;
	
	// add item to order:
	@Operation(summary = "Add item to order")
	@ApiResponses({
	    @ApiResponse(responseCode = "201", description = "Item added successfully"),
	    @ApiResponse(responseCode = "404", description = "Order or product not found")
	})
	@PostMapping
	public ResponseEntity<OrderItemResponseDTO> addItemToOrder(@PathVariable Long orderId, @RequestBody @Valid OrderItemRequestDTO request){
		OrderItemResponseDTO response = oiService.addItemToOrder(orderId, request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	// find items from orderid:
	@Operation(summary = "Get all items from an order")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", description = "Items retrieved successfully")
	})
	@GetMapping
	public ResponseEntity<List<OrderItemResponseDTO>> getItemsByOrderId(@PathVariable Long orderId){
		List<OrderItemResponseDTO> response = oiService.getItemsByOrderId(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	// delete items:
	@Operation(summary = "Delete item from order")
	@ApiResponses({
	    @ApiResponse(responseCode = "204", description = "Item deleted successfully"),
	    @ApiResponse(responseCode = "404", description = "Item not found")
	})
	@DeleteMapping("/{orderItemId}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long orderItemId){
		oiService.deleteItem(orderItemId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
