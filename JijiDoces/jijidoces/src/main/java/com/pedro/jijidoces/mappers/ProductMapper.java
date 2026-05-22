package com.pedro.jijidoces.mappers;

import com.pedro.jijidoces.dtos.product.ProductRequestDTO;
import com.pedro.jijidoces.dtos.product.ProductResponseDTO;
import com.pedro.jijidoces.entities.Product;

public class ProductMapper {
	
	public static Product toEntity(ProductRequestDTO request) {
        return Product.builder().flavour(request.getFlavour()).weight(request.getWeight()).price(request.getPrice()).productType(request.getProductType()).productStyle(request.getProductStyle()).build();
	}
	
	public static ProductResponseDTO toResponse(Product product) {
		return ProductResponseDTO.builder().id(product.getId()).flavour(product.getFlavour()).weight(product.getWeight()).price(product.getPrice()).productType(product.getProductType()).productStyle(product.getProductStyle()).build();
	}
}
