package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.product.dto.ProductPriceDto;

@Service
public interface ProductPriceService {
	
	void updateProductPrice(ProductPriceDto priceDto,UUID uuid);

}
