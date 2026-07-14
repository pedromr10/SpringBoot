package com.pedro.financeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.financeapi.dto.user.UserRequestDTO;
import com.pedro.financeapi.dto.user.UserResponseDTO;
import com.pedro.financeapi.entity.User;
import com.pedro.financeapi.mapper.UserMapper;
import com.pedro.financeapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserMapper userMapper;
	
	//create user:
	public UserResponseDTO createUser(UserRequestDTO request) {
		User user = userMapper.toEntity(request);
		
		User savedUser = userRepo.save(user);
		return userMapper.toResponse(savedUser);
	}
	
	//get all users:
	public List<UserResponseDTO> getAllUsers(){
		return userRepo.findAll().stream().map(userMapper::toResponse).toList();
	}
}
