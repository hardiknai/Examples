package com.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.model.Book;
import com.org.repository.BookRepository;
import com.org.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void deleteBook(Long id) {
		bookRepository.delete(id);
	}

	@Override
	public Book updateBook(Long id, Book newBook) {
		Book oldBook = bookRepository.findOne(id);
		oldBook.setAuthor(newBook.getAuthor());
		oldBook.setName(newBook.getName());
		return bookRepository.save(oldBook);
	}

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBook(Long id) {
		return bookRepository.findOne(id);
				//.orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
	}

	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

}
