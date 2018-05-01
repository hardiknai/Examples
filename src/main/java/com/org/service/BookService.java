package com.org.service;

import java.util.List;

import org.springframework.security.access.prepost.PreFilter;

import com.org.model.Book;

public interface BookService {

	@PreFilter("hasAuthority('USER')")
	public Book getBook(Long id);

	@PreFilter("hasAuthority('USER')")
	public List<Book> getBooks();

	public void deleteBook(Long id);

	public Book updateBook(Long id, Book book);
	
	public Book createBook(Book book);

}
