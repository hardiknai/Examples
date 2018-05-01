package com.org.security;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.org.repository.UserRepository;

//@WithMockUser
public class SecurityMethodTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	//@WithMockUser(username="hardik.nai92@gmail.com", password="Hardik@123")
	public void findAllMessages(){
		userRepository.findAll();
	}
}
