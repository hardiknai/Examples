package com.org.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.org.config.RequestPath;
import com.org.model.Author;
import com.org.model.Book;
import com.org.service.StorageService;

@RestController
public class FileUploadController {

	@Autowired
	private StorageService storageService; 
	
	@PostMapping(RequestPath.UPLOAD)
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String text = storageService.store(file);
		return fileName + " ===> " + text;
	}

	@GetMapping(RequestPath.Upload.GET)
	public ResponseEntity<List<Book>> getUploadFiles() throws FileNotFoundException{

		List<Book> books = new ArrayList<>();
		books.add(new Book(1l, "hardik", new Author(1l, "Java")));
		if (true)
			throw new FileNotFoundException("File Not Found");
		return ResponseEntity.ok().body(books);
	}
	
}
