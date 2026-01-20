package com.looks.FashionCorp.Services;

import java.util.List;

import com.looks.FashionCorp.Dtos.CategoryDto;

public interface CategoryService {
	
	CategoryDto addCategory(CategoryDto categoryDto);
	
	CategoryDto getCategoryById(Integer id);
	
	List<CategoryDto> getAllCategory();
	
	CategoryDto updateCategory(CategoryDto categoryDto, Integer id);
	
	void deleteCategory(Integer id);

}
