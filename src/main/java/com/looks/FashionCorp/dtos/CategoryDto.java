package com.looks.FashionCorp.Dtos;


import java.util.ArrayList;
import java.util.List;

import com.looks.FashionCorp.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	
	private Integer id;
	
	 @NotBlank(message = "Category name cannot be empty")
	 @Size(min = 3, max = 50, message = "Category name must be between 3 and 50 characters")
	 private String name;
	 
	 private List<Product> products = new ArrayList<Product>();

}
