package com.pedro.financeapi.mapper;

import org.springframework.stereotype.Component;

import com.pedro.financeapi.dto.user.UserRequestDTO;
import com.pedro.financeapi.dto.user.UserResponseDTO;
import com.pedro.financeapi.entity.User;

@Component
public class UserMapper {
	
	//dto to entity:
	public User toEntity(UserRequestDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		
		return user;
	}
	
	//entity to dto:
	public UserResponseDTO toResponse(User user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		
		return dto;
	}
}
