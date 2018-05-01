package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmail(String email);
}
