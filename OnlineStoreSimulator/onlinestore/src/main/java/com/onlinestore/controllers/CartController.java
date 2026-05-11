package com.onlinestore.controllers;

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

import com.onlinestore.dtos.AddProductToCartRequestDto;
import com.onlinestore.dtos.CartResponseDto;
import com.onlinestore.services.CartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	//create cart:
	@PostMapping
	public ResponseEntity<CartResponseDto> createCart() {
		CartResponseDto response = cartService.createCart();
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	//find cart by id:
	@GetMapping("/{cartId}")
	public ResponseEntity<CartResponseDto> findCartById(@PathVariable Long cartId){
		CartResponseDto response = cartService.findCartById(cartId);
		return ResponseEntity.status(HttpStatus.OK).body(response); 
	}
	
	//insert product to cart:
	@PostMapping("/{cartId}/items")
	public ResponseEntity<CartResponseDto> addProductToCart(@PathVariable Long cartId, @RequestBody @Valid AddProductToCartRequestDto item){
		CartResponseDto response = cartService.addProductToCart(cartId, item);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//delete item from cart:
	@DeleteMapping("/{cartId}/items/{itemId}")
	public ResponseEntity<CartResponseDto> deleteItem(@PathVariable Long cartId, @PathVariable Long itemId){
		CartResponseDto response = cartService.deleteItem(cartId, itemId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
}









