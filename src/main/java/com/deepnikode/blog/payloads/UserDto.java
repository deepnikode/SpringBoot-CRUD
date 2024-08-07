package com.deepnikode.blog.payloads;

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
	private String name;
	private String email;
	private String password;
	private String about;

	
}
