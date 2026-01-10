package com.looks.FashionCorp.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.looks.FashionCorp.dtos.ProductDto;
import com.looks.FashionCorp.entites.Product;
import com.looks.FashionCorp.repositories.ProductRepository;
import com.looks.FashionCorp.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product savedProduct = productRepository.save(product);
		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public ProductDto getProduct(int id) {
		Product findProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id Not Found"));
		return modelMapper.map(findProduct, ProductDto.class);
	}
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, int id) {
		Product findProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id Not Found"));
		findProduct.setName(productDto.getName());
		findProduct.setPrice(productDto.getPrice());
		findProduct.setQuantity(productDto.getQuantity());
		Product savedProduct = productRepository.save(findProduct);
		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public void deleteProduct(int id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id Not Found"));
		productRepository.delete(product);
		
	}


	

}
