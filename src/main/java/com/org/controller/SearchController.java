package com.org.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.config.RequestPath;
import com.org.es.model.Users;
import com.org.es.repository.UserRepository;

@RestController
public class SearchController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(RequestPath.Search.NAME)
	public List<Users> searchName(@PathVariable final String text){
		return userRepository.findByName(text);
	}
	
	@GetMapping(RequestPath.Search.SALARY)
	public List<Users> searchSalary(@PathVariable final Long salary){
		return userRepository.findBySalary(salary);
	}
	
	@GetMapping(RequestPath.Search.All)
	public List<Users> searchAll(){
		List<Users> usersList = new ArrayList<>();
		Iterable<Users> iteratorUsers = userRepository.findAll();
		iteratorUsers.forEach(usersList::add);
		return usersList;
	}
	
}
