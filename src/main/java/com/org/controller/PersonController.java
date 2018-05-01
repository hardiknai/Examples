package com.org.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.config.RequestPath;
import com.org.model.Person;

@RestController
public class PersonController {

	@GetMapping(RequestPath.Person.GET)
	public Person getPerson() {
		return new Person(1l, "Hardik");

	}
}
