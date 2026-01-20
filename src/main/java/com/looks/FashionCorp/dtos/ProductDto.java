package com.looks.FashionCorp.Dtos;


import com.looks.FashionCorp.entities.Category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	private Integer id;
	
	@NotBlank(message = "Product name cannot be empty")
	@Size(min = 3, max = 100)
	private String name;

	@Min(value = 0, message = "Quantity cannot be negative")
	private int quantity;

	@Positive(message = "Price must be greater than zero")
	private double price;
	
	private Category category;


}
