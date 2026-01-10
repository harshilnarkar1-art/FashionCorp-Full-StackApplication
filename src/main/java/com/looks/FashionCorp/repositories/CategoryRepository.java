package com.looks.FashionCorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.looks.FashionCorp.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	

}
