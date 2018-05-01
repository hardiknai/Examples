package com.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.Application;
import com.org.config.RequestPath;
import com.org.model.Author;
import com.org.service.AuthorService;

@RestController
public class AuthorController {

	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private AuthorService authorService;

	@GetMapping(RequestPath.AUTHOR)
	public List<Author> getAuthors() {
		LOGGER.info("Call getAuthors");
		return authorService.getAuthors();
	}

	@GetMapping(RequestPath.Author.BY_ID)
	public Author getAuthor(@PathVariable Long id) {
		LOGGER.info("Call getAuthor");
		return authorService.getAuthor(id);
	}

	@DeleteMapping(RequestPath.Author.BY_ID)
	public void deleteAuthor(@PathVariable Long id) {
		LOGGER.info("Call deleteAuthor");
		authorService.deleteAuthor(id);
	}

	@PutMapping(RequestPath.Author.BY_ID)
	public Author updateAuthor(@PathVariable(name = "id") Long id, @Valid @RequestBody Author author) {
		LOGGER.info("Call updateAuthor");
		return authorService.updateAuthor(id, author);
	}

	@PostMapping(RequestPath.AUTHOR)
	public Author createAuthor(@Valid @RequestBody Author author) {
		LOGGER.info("Call createAuthor");
		return authorService.createAuthor(author);
	}
}
