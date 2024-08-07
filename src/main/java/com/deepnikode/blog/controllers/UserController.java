package com.deepnikode.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepnikode.blog.payloads.UserDto;
import com.deepnikode.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController 
{
	// C -- POST-create user
	// R -- GET get user
	// U -- PUT -update user
	// D -- DELETE-delete user

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	

}
