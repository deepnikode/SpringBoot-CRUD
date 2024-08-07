package com.deepnikode.blog.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepnikode.blog.entities.User;
import com.deepnikode.blog.exceptions.*;
import com.deepnikode.blog.payloads.UserDto;
import com.deepnikode.blog.repositories.UserRepo;
import com.deepnikode.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	
	// Method to Create Users
	@Override
	public UserDto createUser(UserDto userDto) {

		User user=this.dtoToUser(userDto);
		
		User savedUser=this.userRepo.save(user);
		
		System.out.println("User Created");
		return this.userToDto(savedUser);
	}
	
	
	// Method to Update Users
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) 
	{
		
		User user=this.userRepo.findById(userId)
					  .orElseThrow(
							  		()-> new ResourceNotFoundException("User","id",userId)
							  	  );
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser=this.userRepo.save(user);
		
		UserDto userDto1 =this.userToDto(updatedUser);
		
		return userDto1;
	}
	
	
	// Method to get single User
	@Override
	public UserDto getUserById(Integer userId) 
	{
		User user=this.userRepo.findById(userId)
				  .orElseThrow(
						  		()-> new ResourceNotFoundException("User","id",userId)
						  	  );
		
		
		return this.userToDto(user);
	}

	
	// Method to get All Users
	@Override
	public List<UserDto> getAllUsers() 
	{
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDto = users.stream()
								.map(user->this.userToDto(user))
								.collect(Collectors.toList());
		
		return userDto;
	}

	
	// Method to Delete User
	@Override
	public void deleteUser(Integer userId) 
	{
		User user=this.userRepo.findById(userId)
				  .orElseThrow(
						  		()-> new ResourceNotFoundException("User","id",userId)
						  	  );
		this.userRepo.delete(user);

	}
	
	
	// Converting DTO to users
	public User dtoToUser(UserDto userDto)
	{
		User user=new User();
		
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		return user;
	}
	
	// Converting users to DTO
	public UserDto userToDto(User user)
	{
		UserDto userDto=new UserDto();
		
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		
		return userDto;
	}

}
