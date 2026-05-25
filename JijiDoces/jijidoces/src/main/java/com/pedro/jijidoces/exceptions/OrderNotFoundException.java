package com.pedro.jijidoces.exceptions;

public class OrderNotFoundException extends RuntimeException{

	public OrderNotFoundException(String message) {
		super(message);
	}
}
