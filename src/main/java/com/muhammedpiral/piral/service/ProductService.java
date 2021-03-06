package com.muhammedpiral.piral.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.dto.product.ProductDto;
import com.muhammedpiral.piral.entity.product.Product;

@Service
public interface ProductService {
	
	 void saveProduct(ProductDto productDto);
	
	 List<ProductDto> findAll();
	 
	 List<ProductDto> findByCategory(String category);
	 
	 void deleteProduct(UUID uuid);

	 Product findByUuid(UUID uuid);

	 void updateProduct(ProductDto productDto,UUID uuid);

}
