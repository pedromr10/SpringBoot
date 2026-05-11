package com.onlinestore.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//product not found:
	@ExceptionHandler(ProductNotFoundException.class )
	public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException e, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setPath(request.getRequestURI());
		error.setMessages(List.of(e.getMessage()));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	
	//cart not found:
	@ExceptionHandler(CartNotFoundException.class )
	public ResponseEntity<ErrorResponse> handleCartNotFound(CartNotFoundException e, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setPath(request.getRequestURI());
		error.setMessages(List.of(e.getMessage()));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	//@valid validation:
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
		List<String> errors = e.getBindingResult().getFieldErrors().stream().map(err -> err.getDefaultMessage()).toList();
		
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setPath(request.getRequestURI());
		error.setMessages(errors);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	//Generic error
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericError(Exception e, HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setPath(request.getRequestURI());
		error.setMessages(List.of("Unexpected error"));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
	
	//product already exists:
	@ExceptionHandler(ProductAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handlerProductAlreadyExists(ProductAlreadyExistsException  e, HttpServletRequest request) {
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setPath(request.getRequestURI());
		error.setMessages(List.of(e.getMessage()));
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	//cart item not found:
	@ExceptionHandler(CartItemNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerCartItemNotFound(CartItemNotFoundException e, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setPath(request.getRequestURI());
		error.setMessages(List.of(e.getMessage()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	//insufficient stock:
	@ExceptionHandler(InsufficientStockException.class)
	public ResponseEntity<ErrorResponse> handlerInsufficientStock(InsufficientStockException e, HttpServletRequest request){
		ErrorResponse error = new ErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.CONFLICT.value());
		error.setPath(request.getRequestURI());
		error.setMessages(List.of(e.getMessage()));
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	
	
	
}
