package com.looks.FashionCorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.looks.FashionCorp.entites.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);

}
