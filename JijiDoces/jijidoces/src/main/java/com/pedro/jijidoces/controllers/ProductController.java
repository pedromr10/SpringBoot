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

import jakarta.validation.Valid;

@RequestMapping("/products")
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	//add product:
	@PostMapping
	public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody @Valid ProductRequestDTO request) {
		ProductResponseDTO response = productService.addProduct(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	//get product by id:
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
		ProductResponseDTO response = productService.getProductById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//get all products:
	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
		List<ProductResponseDTO> list = productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	//update product:
	@PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id,@RequestBody @Valid ProductRequestDTO request) {
        ProductResponseDTO response = productService.updateProduct(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
	
	//delete product:
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
	
}




