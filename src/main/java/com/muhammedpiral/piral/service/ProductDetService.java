package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.product.dto.ProductDetailDto;

@Service
public interface ProductDetService {

	
	void updateProductDet(ProductDetailDto detailDto,UUID uuid);
	
	
}
