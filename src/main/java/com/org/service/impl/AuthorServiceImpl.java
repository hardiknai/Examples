package com.org.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Application;
import com.org.model.Author;
import com.org.repository.AuthorRepository;
import com.org.repository.BookRepository;
import com.org.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void deleteAuthor(Long id) {
		int noOfBookWrited = bookRepository.countByAuthorId(id);
		if(noOfBookWrited > 0) {
			LOGGER.error("This author already writen " + noOfBookWrited + " book" + (noOfBookWrited > 1 ? "s" : ""));
			throw new RuntimeException("This author already writen " + noOfBookWrited + " book" + (noOfBookWrited > 1 ? "s" : ""));
		}else {
			authorRepository.delete(id);
		}
			
	}

	@Override
	public Author updateAuthor(Long id, Author newAuthor) {
		Author oldAuthor = authorRepository.findOne(id);
		oldAuthor.setName(newAuthor.getName());
		return authorRepository.save(oldAuthor);
	}

	@Override
	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author getAuthor(Long id) {
		return authorRepository.findOne(id);
				//.orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
	}

	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}


	
}