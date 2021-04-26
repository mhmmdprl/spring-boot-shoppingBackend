package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.dto.product.ProductDetailDto;

@Service
public interface ProductDetService {

	
	void updateProductDet(ProductDetailDto detailDto,UUID uuid);
	
	
}
