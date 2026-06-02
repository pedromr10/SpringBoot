package com.pedro.jijidoces.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.jijidoces.dtos.product.ProductRequestDTO;
import com.pedro.jijidoces.dtos.product.ProductResponseDTO;
import com.pedro.jijidoces.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Products")
@RequestMapping("/api/v1/products")
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//add product:
	@Operation(summary = "Create a new product")
	@PostMapping
	public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody @Valid ProductRequestDTO request) {
		ProductResponseDTO response = productService.addProduct(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	//get product by id:
	@Operation(summary = "Get product by id")
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
		ProductResponseDTO response = productService.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//get all products:
	@Operation(summary = "Get all products")
	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
		List<ProductResponseDTO> list = productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	//update product:
	@Operation(summary = "Update product")
	@PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id,@RequestBody @Valid ProductRequestDTO request) {
        ProductResponseDTO response = productService.updateProduct(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
	
	//delete product:
	@Operation(summary = "Delete product")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
	
}




