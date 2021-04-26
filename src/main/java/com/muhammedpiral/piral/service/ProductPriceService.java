package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.dto.product.ProductPriceDto;

@Service
public interface ProductPriceService {
	
	void updateProductPrice(ProductPriceDto priceDto,UUID uuid);

}
