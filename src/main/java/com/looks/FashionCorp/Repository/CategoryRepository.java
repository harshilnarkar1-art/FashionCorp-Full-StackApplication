package com.looks.FashionCorp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.looks.FashionCorp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
	Optional<Category> findByName(String name);
	
	
}
