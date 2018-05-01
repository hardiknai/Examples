package com.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.annotation.CurrentUser;
import com.org.config.RequestPath;
import com.org.model.User;
import com.org.service.impl.UserDetailsServiceImp;

@RestController
public class UserController {

	@Autowired
	private UserDetailsServiceImp userDetailsService;  
	
	@GetMapping(RequestPath.User.CURRENT)
	public User list(@CurrentUser User user) {
	//public User list(@AuthenticationPrincipal User user) {
	//public User list(Authentication authentication) {
		//SecurityContext context = SecurityContextHolder.getContext();
		//Authentication authentication = context.getAuthentication();
		//User user = authentication == null ? null : (User) authentication.getPrincipal();
		return user;
	}
	@PostMapping(RequestPath.USER)
	public void createUser(@Valid @RequestBody User user){
		userDetailsService.createUser(user);
	}
	
	@GetMapping(RequestPath.USER)
	public List<User> getAllUser(){
		return userDetailsService.getAllUser();
	}
}
