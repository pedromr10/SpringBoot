package com.onlinestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinestore.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
