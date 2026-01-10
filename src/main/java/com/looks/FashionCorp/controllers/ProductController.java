package com.looks.FashionCorp.controllers;

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

import com.looks.FashionCorp.dtos.ProductDto;
import com.looks.FashionCorp.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
		ProductDto product = productService.addProduct(productDto);
		return new ResponseEntity<ProductDto>(product, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable int id){
		ProductDto product = productService.getProduct(id);
		return new ResponseEntity<ProductDto>(product, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable int id){
		ProductDto updatedProduct = productService.updateProduct(productDto, id);
		return new ResponseEntity<ProductDto>(updatedProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable int id){
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> allProducts = productService.getAllProducts();
		return new ResponseEntity<List<ProductDto>>(allProducts, HttpStatus.OK);
	}
}
