package com.onlinestore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.dtos.OrderResponseDto;
import com.onlinestore.services.CheckoutService;

@RestController
@RequestMapping("/api/v1/carts")
public class CheckoutController {
	
    @Autowired
    private CheckoutService checkoutService;
    
    @PostMapping("/{cartId}/checkout")
    public ResponseEntity<OrderResponseDto> checkout(@PathVariable Long cartId) {
        OrderResponseDto response = checkoutService.checkout(cartId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
