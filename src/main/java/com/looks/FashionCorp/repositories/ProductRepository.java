package com.looks.FashionCorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.looks.FashionCorp.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
