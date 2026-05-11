package com.onlinestore.dtos;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "Cart data returned by the API")
public class CartResponseDto {
	@Schema(description = "Cart ID", example = "1")
	private Long id;
	@Schema(description = "List of cart items", example = "[{ \\\"productId\\\": 1, \\\"productName\\\": \\\"Mouse\\\", \\\"price\\\": 100, \\\"quantity\\\": 2 }]")
	private List<CartItemResponseDto> items;
	private BigDecimal totalPrice;
	
}




