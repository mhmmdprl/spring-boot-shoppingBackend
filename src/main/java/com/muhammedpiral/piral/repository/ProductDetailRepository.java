package com.muhammedpiral.piral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhammedpiral.piral.entity.product.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

	ProductDetail findByProductId(Long id);

}
