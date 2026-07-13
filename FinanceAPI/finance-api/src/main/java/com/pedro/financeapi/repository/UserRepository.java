package com.pedro.financeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.financeapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
