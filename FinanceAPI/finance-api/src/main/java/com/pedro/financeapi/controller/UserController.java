package com.pedro.financeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.financeapi.dto.user.UserRequestDTO;
import com.pedro.financeapi.dto.user.UserResponseDTO;
import com.pedro.financeapi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create user:
	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto){
		UserResponseDTO responseDto = userService.createUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
	}

}
