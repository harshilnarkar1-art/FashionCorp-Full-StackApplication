package com.looks.FashionCorp.Services;

import java.util.List;

import com.looks.FashionCorp.Dtos.ProductDto;
import com.looks.FashionCorp.exceptions.ProductNotFoundException;

public interface ProductService {

	ProductDto addProduct(ProductDto productDto);
	
	ProductDto getProduct(Integer id) throws ProductNotFoundException;
	
	List<ProductDto> getAllProducts();
	
	ProductDto updateProduct(ProductDto productDto, Integer id);
	
	void deleteProduct(Integer id);
	
}
