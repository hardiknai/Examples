package com.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.model.CustomUserDetails;
import com.org.model.User;
import com.org.repository.UserRepository;


@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOneByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username + "User not found");
		}
		return new CustomUserDetails(user);
	}

	public void createUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}
