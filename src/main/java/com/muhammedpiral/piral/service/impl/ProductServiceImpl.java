package com.muhammedpiral.piral.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.product.Product;
import com.muhammedpiral.piral.entity.product.dto.ProductDetailDto;
import com.muhammedpiral.piral.entity.product.dto.ProductDto;
import com.muhammedpiral.piral.entity.product.dto.ProductPriceDto;
import com.muhammedpiral.piral.repository.ProductRepository;
import com.muhammedpiral.piral.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Transactional
	@Override
	public void saveProduct(ProductDto productDto) {

		this.productRepository.save(Product.builder().name(productDto.getName())
				.productPrice(ProductPriceDto.of(productDto.getProductPriceDto())).available(productDto.getAvailable())
				.createdDate(productDto.getCreatedDate()).images(productDto.getImages())
				.category(productDto.getCategory())
				.productDetails(ProductDetailDto.of(productDto.getProductDetailsDto())).build());
	}

	@Transactional
	@Override
	public List<ProductDto> findAll() {

		List<ProductDto> productDtos = this.productRepository.findAll().stream().map(ProductDto::of)
				.collect(Collectors.toList());
		return productDtos;
	}

	@Transactional
	@Override
	public List<ProductDto> findByCategory(String category) {
		List<ProductDto> productDtos = this.productRepository.findByCategory(category).stream().map(ProductDto::of)
				.collect(Collectors.toList());
		return productDtos;
	}

	@Override
	public void deleteProduct(UUID uuid) {
		this.productRepository.delete(uuid);

	}

	@Override
	@Transactional

	public void updateProduct(ProductDto productDto, UUID uuid) {
		Product product = this.productRepository.findByUuid(uuid);
		product.setAvailable(productDto.getAvailable());
		product.setImages(productDto.getImages());
		product.setProductPrice(ProductPriceDto.of(productDto.getProductPriceDto()));
		product.setProductDetails(ProductDetailDto.of(productDto.getProductDetailsDto()));

		this.productRepository.save(product);

//		this.productRepository.save(Product.builder()
//				.name(productDto.getName())
//				.productPrice(ProductPriceDto.of(productDto.getProductPriceDto()))
//				.available(productDto.getAvailable())
//				.createdDate(productDto.getCreatedDate())
//				.code(productDto.getCode())
//				.images(productDto.getImages())
//				.category(productDto.getCategory())
//				.productDetails(ProductDetailDto.of(productDto.getProductDetailsDto()))
//				.build());

	}

	@Override
	public Product findByUuid(UUID uuid) {
		return this.productRepository.findByUuid(uuid);
	}

}
