package com.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.config.RequestPath;
import com.org.model.Book;
import com.org.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping(RequestPath.BOOK)
	public List<Book> getBooks(){
		return bookService.getBooks();
	}
	
	@GetMapping(RequestPath.Book.BY_ID)
	public Book getBook(@PathVariable Long id){
		return bookService.getBook(id);
	}
	
	
	@DeleteMapping(RequestPath.Book.BY_ID)
	public void deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
	}	
	
	@PutMapping(RequestPath.Book.BY_ID)
	public void updateBook(@PathVariable Long id,@Valid @RequestBody Book book){
		bookService.updateBook(id, book);
	}

	@PostMapping(RequestPath.BOOK)
	public Book createBook(@Valid @RequestBody Book book){
		return bookService.createBook(book);
	}
	
}
