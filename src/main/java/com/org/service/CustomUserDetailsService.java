package com.org.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.org.model.CustomUserDetails;
import com.org.model.Users;
import com.org.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Users> optionalUsers = usersRepository.finByName(username);
		
		optionalUsers.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
		
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
