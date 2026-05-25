package com.pedro.jijidoces.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.jijidoces.dtos.product.ProductRequestDTO;
import com.pedro.jijidoces.dtos.product.ProductResponseDTO;
import com.pedro.jijidoces.entities.Product;
import com.pedro.jijidoces.exceptions.ProductNotFoundException;
import com.pedro.jijidoces.mappers.ProductMapper;
import com.pedro.jijidoces.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	//add product:
	public ProductResponseDTO addProduct(ProductRequestDTO request) {
		Product product = ProductMapper.toEntity(request);
		Product savedProduct = productRepo.save(product);
		return ProductMapper.toResponse(savedProduct);
	}
	
	//get product by id:
	public ProductResponseDTO getProductById(Long id) {
		Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Produto nao encontrado"));
		return ProductMapper.toResponse(product);
	}
	
	//get all products:
	public List<ProductResponseDTO> getAllProducts(){
		List<Product> list = productRepo.findAll();
		return list.stream().map(ProductMapper::toResponse).toList();
	}
	
	//delete product:
	public void deleteProduct(Long id) {
	    Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Produto nao encontrado"));
	    productRepo.delete(product);
	}
	
	//update product:
	public ProductResponseDTO updateProduct(Long id, ProductRequestDTO request) {
	    Product product = productRepo.findById(id)
	            .orElseThrow(() -> new ProductNotFoundException("Produto nao encontrado"));
	    product.setFlavour(request.getFlavour());
	    product.setWeight(request.getWeight());
	    product.setPrice(request.getPrice());
	    product.setProductType(request.getProductType());
	    product.setProductStyle(request.getProductStyle());
	    Product updatedProduct = productRepo.save(product);
	    return ProductMapper.toResponse(updatedProduct);
	}
	
}
