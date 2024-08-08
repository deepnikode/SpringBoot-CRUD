package com.deepnikode.blog.controllers;

import java.util.List;
import java.util.Map;

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

import com.deepnikode.blog.payloads.ApiResponse;
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
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uId)
	{	
		UserDto updatedUser= this.userService.updateUser(userDto, uId);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uId)
	{
		this.deleteUser(uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true), HttpStatus.OK);
	}	
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{	
		List<UserDto> userDto= this.userService.getAllUsers();
		return ResponseEntity.ok(userDto);
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId)
	{	
		UserDto userDto= this.userService.getUserById(userId);
		return ResponseEntity.ok(userDto);
	}
	

}
