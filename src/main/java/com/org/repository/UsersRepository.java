package com.org.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	Optional<Users> finByName(String username);

}
