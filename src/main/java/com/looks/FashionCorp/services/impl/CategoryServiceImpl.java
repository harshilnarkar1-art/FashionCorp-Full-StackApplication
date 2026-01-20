package com.looks.FashionCorp.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.looks.FashionCorp.Dtos.CategoryDto;
import com.looks.FashionCorp.Repository.CategoryRepository;
import com.looks.FashionCorp.Services.CategoryService;
import com.looks.FashionCorp.entities.Category;
import com.looks.FashionCorp.exceptions.CategoryNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepository categoryRepositories;

	@Override
	@Transactional
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
		Category savedCategory = categoryRepositories.save(category);
		return modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	@Transactional
	public CategoryDto getCategoryById(Integer id) {
		Category category = categoryRepositories.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category Not Found"));
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	@Transactional
	public List<CategoryDto> getAllCategory() {
		List<CategoryDto> list = categoryRepositories.findAll().stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	@Transactional
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
		Category category = categoryRepositories.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category Not Found"));
		category.setName(categoryDto.getName());
		categoryRepositories.save(category);

		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	@Transactional
	public void deleteCategory(Integer id) {
		if(!categoryRepositories.existsById(id)) {
			throw new CategoryNotFoundException("Category Not Found");
		}
		categoryRepositories.deleteById(id);
	}

}
