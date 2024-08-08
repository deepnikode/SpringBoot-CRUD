package com.deepnikode.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Lambok is used here for creating No arg constructor, Getters & Setters

@NoArgsConstructor
@Getter
@Setter
public class UserDto 
{
	private int id;
	
	@NotEmpty
	@Size(min=4, message="Username must be minimum 4 character!!")
	private String name;
	
	@Email(message="Email not valid!!")
	private String email;
	
	@NotEmpty
	
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Password must be at least 8 characters long, including at least one uppercase letter, one lowercase letter, and one number.")
	private String password;
	
	@NotEmpty
	private String about;

	
}
