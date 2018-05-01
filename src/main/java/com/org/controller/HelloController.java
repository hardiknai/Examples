package com.org.controller;

import java.util.Locale;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.org.config.RequestPath;

@RestController
public class HelloController {

	 @Autowired
     private MessageSource messageSource;

	
	@GetMapping(RequestPath.HELLO)
	public String index(@AuthenticationPrincipal final UserDetails userDetails){
		return "Greeting from Spring Boot!" + messageSource.getMessage("TermNotFoundException", new String[]{"Hardik"}, Locale.getDefault());
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@HystrixCommand(fallbackMethod = "fallBackDetail", commandKey ="hello", groupKey = "hello")
	@GetMapping(RequestPath.DETAIL)
	public String employee(){
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("Failed!");
		}
		return "{Name: Hardik Nai, Mo: 9725960834}";
	}
	
	public String fallBackDetail(){
		return "Fall Back Hello initiated";
	}
}
