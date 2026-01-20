package com.looks.FashionCorp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.looks.FashionCorp.Dtos.CategoryDto;
import com.looks.FashionCorp.Services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto category = categoryService.addCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int id){
		CategoryDto categoryById = categoryService.getCategoryById(id);
		return new ResponseEntity<CategoryDto>(categoryById, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(allCategory,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable int id){
		CategoryDto updateCategory = categoryService.updateCategory(categoryDto, id);
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id){
		categoryService.deleteCategory(id);
		return new ResponseEntity<String>("Category Deleted",HttpStatus.OK);
	}
	

}
