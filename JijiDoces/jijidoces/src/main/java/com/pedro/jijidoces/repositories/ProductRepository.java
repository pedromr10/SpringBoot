package com.pedro.jijidoces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.jijidoces.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
