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

@Schema(description = "Order item data returned by the API")
public class OrderItemResponseDto {
	@Schema(description = "Product name", example = "Gaming Mouse")
	private String productName;
	@Schema(description = "Product price at purchase time", example = "199.90")
	private BigDecimal productPrice;
	@Schema(description = "Quantity purchased", example = "2")
	private Integer quantity;
	@Schema(description = "Subtotal for this item", example = "399.80")
	private BigDecimal subtotal;
}
