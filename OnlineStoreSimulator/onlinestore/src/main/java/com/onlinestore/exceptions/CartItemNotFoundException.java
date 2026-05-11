package com.onlinestore.exceptions;

public class CartItemNotFoundException extends RuntimeException{
	public CartItemNotFoundException(String message) {
	    super(message);
	}
}
