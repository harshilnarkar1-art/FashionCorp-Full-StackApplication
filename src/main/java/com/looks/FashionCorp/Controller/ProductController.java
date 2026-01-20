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

import com.looks.FashionCorp.Dtos.ProductDto;
import com.looks.FashionCorp.Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
		ProductDto product = productService.addProduct(productDto);
		return new ResponseEntity<ProductDto>(product, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable int id){
		ProductDto product = productService.getProduct(id);
		return new ResponseEntity<ProductDto>(product, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> list = productService.getAllProducts();
		return new ResponseEntity<List<ProductDto>>(list,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable int Id){
		ProductDto updateProduct = productService.updateProduct(productDto, Id);
		return new ResponseEntity<ProductDto>(updateProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
	}

}
