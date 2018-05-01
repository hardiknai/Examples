package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
