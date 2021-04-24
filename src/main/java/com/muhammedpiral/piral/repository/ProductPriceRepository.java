package com.muhammedpiral.piral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhammedpiral.piral.entity.product.ProductPrice;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
	
	ProductPrice findByProductId(Long id);
}
