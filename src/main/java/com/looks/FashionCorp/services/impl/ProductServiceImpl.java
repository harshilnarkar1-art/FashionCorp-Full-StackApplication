package com.looks.FashionCorp.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.looks.FashionCorp.Dtos.ProductDto;
import com.looks.FashionCorp.Repository.ProductRepository;
import com.looks.FashionCorp.Services.ProductService;
import com.looks.FashionCorp.entities.Product;
import com.looks.FashionCorp.exceptions.ProductNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductRepository productRepositories;

	@Override
	@Transactional
	public ProductDto addProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product savedProduct = productRepositories.save(product);
		
		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	@Transactional
	public ProductDto getProduct(Integer id){
		Product product = productRepositories.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
		
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	@Transactional
	public ProductDto updateProduct(ProductDto productDto, Integer id) {
		Product product = productRepositories.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
		
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		Product savedProduct = productRepositories.save(product);

		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	@Transactional
	public List<ProductDto> getAllProducts() {
		List<ProductDto> list = productRepositories.findAll().stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		
		return list;
	}
	
	@Override
	@Transactional
	public void deleteProduct(Integer id) {
		Product product = productRepositories.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
		productRepositories.delete(product);
	}

}
