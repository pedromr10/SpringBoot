package com.pedro.financeapi.controller;

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

	//get all users:
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
		List<UserResponseDTO> responseList = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(responseList);
	}
	
	//get user by id:
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
		UserResponseDTO response = userService.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//update user:
	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestDTO request, @PathVariable Long id){
		UserResponseDTO response = userService.updateUser(id, request);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//delete user:
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}




















