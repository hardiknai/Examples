package com.org.service;

import java.util.List;

import org.springframework.security.access.prepost.PreFilter;

import com.org.model.Author;

public interface AuthorService {


	@PreFilter("hasAuthority('USER')")
	public Author getAuthor(Long id);

	@PreFilter("hasAuthority('USER')")
	public List<Author> getAuthors();

	public void deleteAuthor(Long id);

	public Author updateAuthor(Long id, Author author);
	
	public Author createAuthor(Author author);
}
