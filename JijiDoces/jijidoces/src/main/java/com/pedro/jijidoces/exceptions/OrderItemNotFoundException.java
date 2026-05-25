package com.pedro.jijidoces.exceptions;

public class OrderItemNotFoundException extends RuntimeException{

	public OrderItemNotFoundException(String message) {
		super(message);
	}
}
