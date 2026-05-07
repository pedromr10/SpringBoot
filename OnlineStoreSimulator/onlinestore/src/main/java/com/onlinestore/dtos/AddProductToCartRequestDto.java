package com.onlinestore.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "Data required to add a product to a cart")
public class AddProductToCartRequestDto {
	@NotNull(message = "Product id cannot be null")
	@Schema(description = "Product id", example = "2")
	private Long productId;
	@NotNull(message = "Quantity cannot be null")
	@Positive(message = "Quantity must be greater than zero")
	@Schema(description = "Product quantity", example = "12")
	private Integer quantity;
}
