package com.deepnikode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepnikode.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>
{
	
}
