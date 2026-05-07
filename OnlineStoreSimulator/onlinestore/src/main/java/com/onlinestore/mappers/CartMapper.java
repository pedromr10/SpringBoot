package com.onlinestore.mappers;

import org.springframework.stereotype.Component;

import com.onlinestore.dtos.CartItemResponseDto;
import com.onlinestore.dtos.CartResponseDto;
import com.onlinestore.entities.Cart;
import com.onlinestore.entities.CartItem;

@Component
public class CartMapper {

	
	//Cart to CartResponseDto:
	public CartResponseDto toCartResponse(Cart cart) {
		CartResponseDto response = new CartResponseDto();
		response.setId(cart.getId());
		response.setItems(cart.getCartItems().stream().map(this::toCartItemResponse).toList());
		return response;
	}
	
	//CartItem to CartItemResponseDto:
	public CartItemResponseDto toCartItemResponse(CartItem cartitem) {
		CartItemResponseDto cartitemResponse = new CartItemResponseDto();
		cartitemResponse.setProductId(cartitem.getProduct().getId());
		cartitemResponse.setName(cartitem.getProduct().getName());
		cartitemResponse.setPrice(cartitem.getProduct().getPrice());
		cartitemResponse.setQuantity(cartitem.getQuantity());
		return cartitemResponse;
	}
}
