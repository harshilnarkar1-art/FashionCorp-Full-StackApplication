package com.looks.FashionCorp.services;

import java.util.List;

import com.looks.FashionCorp.dtos.ProductDto;

public interface ProductService {
	
	//create
	ProductDto addProduct(ProductDto productDto);
	
	//read
	ProductDto getProduct(int id);
	
	//update
	ProductDto updateProduct(ProductDto productDto, int id);
	
	//delete
	void deleteProduct(int id);
	
	//read all products
	List<ProductDto> getAllProducts();
}
