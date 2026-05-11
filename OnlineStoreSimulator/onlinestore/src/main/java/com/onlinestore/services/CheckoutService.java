package com.onlinestore.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.dtos.OrderResponseDto;
import com.onlinestore.entities.Cart;
import com.onlinestore.entities.CartItem;
import com.onlinestore.entities.Order;
import com.onlinestore.entities.OrderItem;
import com.onlinestore.enums.OrderStatus;
import com.onlinestore.exceptions.CartEmptyException;
import com.onlinestore.exceptions.CartNotFoundException;
import com.onlinestore.exceptions.InsufficientStockException;
import com.onlinestore.mappers.OrderMapper;
import com.onlinestore.repositories.CartRepository;
import com.onlinestore.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class CheckoutService {

	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderMapper orderMapper;
	
	//checkout:
	@Transactional
	public OrderResponseDto checkout(Long cartId) {
		//search for the cart:
		Cart cart = cartRepo.findById(cartId).orElseThrow(()-> new CartNotFoundException("Cart not found"));
		//cart empty validation:
		if(cart.getCartItems().isEmpty()) {
		    throw new CartEmptyException("Cart is empty");
		}
		//creates an order:
		Order order = new Order();
		//set basic infos:
		order.setCreatedAt(LocalDateTime.now());
		order.setStatus(OrderStatus.PENDING);
		
		for(CartItem item : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			if(item.getProduct().getStock() < item.getQuantity()) {
			    throw new InsufficientStockException("Insufficient stock");
			}
			item.getProduct().setStock(item.getProduct().getStock() - item.getQuantity());
			orderItem.setProductName(item.getProduct().getName());
			orderItem.setProductPrice(item.getProduct().getPrice());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setSubtotal(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
			orderItem.setOrder(order);
			order.getItems().add(orderItem);
			
		}
		//set total price:
		order.setTotalPrice(order.getItems().stream().map(OrderItem::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add));
		
		Order savedOrder = orderRepo.save(order);
		cart.getCartItems().clear();
		cartRepo.save(cart);
		return orderMapper.toResponse(savedOrder);
	}
	
}
