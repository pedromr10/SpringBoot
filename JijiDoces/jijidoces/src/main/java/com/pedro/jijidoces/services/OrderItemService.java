package com.pedro.jijidoces.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.jijidoces.dtos.orderItem.OrderItemRequestDTO;
import com.pedro.jijidoces.dtos.orderItem.OrderItemResponseDTO;
import com.pedro.jijidoces.entities.Order;
import com.pedro.jijidoces.entities.OrderItem;
import com.pedro.jijidoces.entities.Product;
import com.pedro.jijidoces.mappers.OrderItemMapper;
import com.pedro.jijidoces.repositories.OrderItemRepository;
import com.pedro.jijidoces.repositories.OrderRepository;
import com.pedro.jijidoces.repositories.ProductRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository oiRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private ProductRepository productRepo;
	
	// add item to order:
	public OrderItemResponseDTO addItemToOrder(OrderItemRequestDTO request) {

	    Order order = orderRepo.findById(request.getOrderId())
	            .orElseThrow(() -> new RuntimeException("Pedido nao encontrado"));
	    Product product = productRepo.findById(request.getProductId())
	            .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
	    OrderItem orderItem = OrderItemMapper.toEntity(request, order, product);
	    OrderItem savedItem = oiRepo.save(orderItem);
	    order.setTotalPrice(
	            order.getTotalPrice().add(savedItem.getSubtotal())
	    );
	    orderRepo.save(order);
	    return OrderItemMapper.toResponse(savedItem);
	}
	
	// find items from orderid:
	public List<OrderItemResponseDTO> getItemsByOrderId(Long orderId){
	    Order order = orderRepo.findById(orderId)
	            .orElseThrow(() -> new RuntimeException("Pedido nao encontrado"));
	    return order.getItems().stream().map(OrderItemMapper::toResponse).toList();
	}
	
	// delete items:
	public void deleteItem(Long orderItemId) {
		OrderItem orderItem = oiRepo.findById(orderItemId).orElseThrow(()-> new RuntimeException("Item nao encontrado"));
		Order order = orderItem.getOrder();
		order.setTotalPrice(order.getTotalPrice().subtract(orderItem.getSubtotal()));
		orderRepo.save(order);
		oiRepo.delete(orderItem);
	}
}



