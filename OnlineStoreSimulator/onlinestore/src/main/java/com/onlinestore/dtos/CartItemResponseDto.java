package com.onlinestore.dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "Cart item data returned by the API")
public class CartItemResponseDto {
	@Schema(description = "Product ID", example = "1")
	private Long productId;
	@Schema(description = "Product name", example = "Gaming Mouse")
	private String name;
	@Schema(description = "Product price", example = "199.90")
	private BigDecimal price;
	@Schema(description = "Quantity of items in cart", example = "10")
	private Integer quantity;
}
