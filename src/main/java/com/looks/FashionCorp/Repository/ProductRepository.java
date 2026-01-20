package com.looks.FashionCorp.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.looks.FashionCorp.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Optional<Product> findByName(String name);
	
	Page<Product> findByPriceLessThanOrderByPriceAsc (double price,Pageable pageable);
	
	Page<Product> findByPriceLessThanOrderByPriceDesc (double price, Pageable pageable);
	
	Page<Product> findByPriceBetween(double startPrice,double endPrice, Pageable pageable);

}
