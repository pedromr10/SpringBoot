package com.onlinestore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.dtos.CartResponseDto;
import com.onlinestore.entities.Cart;
import com.onlinestore.entities.CartItem;
import com.onlinestore.entities.Product;
import com.onlinestore.exceptions.CartNotFoundException;
import com.onlinestore.exceptions.ProductNotFoundException;
import com.onlinestore.mappers.CartMapper;
import com.onlinestore.repositories.CartRepository;
import com.onlinestore.repositories.ProductRepository;

@Service	
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CartMapper cartMapper;
	
	//insert product to cart:
	public CartResponseDto addProductToCart(Long cartId, Long productId, Integer quantity){
		//verifies if quantity is greater than zero:
		if (quantity <= 0) {
		    throw new RuntimeException("Quantity must be greater than zero");
		}
		Cart cart = cartRepo.findById(cartId).orElseThrow(()-> new CartNotFoundException("Cart not found"));
		Product product = productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));
		//verify if product already exists in cart:
		CartItem existingItem = null;
		for(CartItem item: cart.getCartItems()) {
			if(item.getProduct().getId().equals(productId)) {
				existingItem = item;
				break;
			}
		}
		if(existingItem != null) {
			//verifies if it has stock:
			if(product.getStock() < quantity + existingItem.getQuantity()) {
				throw new RuntimeException("Insufficient stock");
			}
			existingItem.setQuantity(quantity + existingItem.getQuantity());
			
		}
		else {
			//verifies if it has stock:
			if(product.getStock() < quantity) {
				throw new RuntimeException("Insufficient stock");
			}
	        CartItem newItem = new CartItem();
	        newItem.setProduct(product);
	        newItem.setQuantity(quantity);
	        newItem.setCart(cart);

	        cart.getCartItems().add(newItem);
		}
		//saving the cart:
		Cart savedCart = cartRepo.save(cart);
		//returning dto:
		return cartMapper.toCartResponse(savedCart);
	}
}
