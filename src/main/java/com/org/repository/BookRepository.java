package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	Integer countByAuthorId(Long id);
}
