package com.org.controller;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String index(@AuthenticationPrincipal final UserDetails userDetails){
		if (userDetails!= null) {
			String username = userDetails.getUsername();
			Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
			authorities.forEach(System.out::println);
		}
		return "Greeting from Spring Boot!";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping("/admin/employee")
	public String employee(){
		return "{Name: Hardik Nai, Mo: 9725960834}";
	}
}
