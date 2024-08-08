package com.deepnikode.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.deepnikode.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest()
	{
		System.out.println(this.userRepo.getClass().getName());
		System.out.println(this.userRepo.getClass().getPackageName());
		
	}
	
	

}
