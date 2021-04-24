package com.muhammedpiral.piral.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.muhammedpiral.piral.entity.product.ProductPrice;
import com.muhammedpiral.piral.entity.product.dto.ProductPriceDto;
import com.muhammedpiral.piral.repository.ProductPriceRepository;
import com.muhammedpiral.piral.repository.ProductRepository;
import com.muhammedpiral.piral.service.ProductPriceService;

public class ProductPriceServiceImpl implements ProductPriceService{
	
	@Autowired
	private ProductPriceRepository productPriceRepository;
	
	@Autowired 
	private ProductRepository productRepository;

	@Override
	public void updateProductPrice(ProductPriceDto priceDto, UUID uuid) {

	ProductPrice productPrice=this.productPriceRepository.findByProductId(this.productRepository.findByUuid(uuid).getId());
		
	productPrice.setPrice(priceDto.getPrice());
	productPrice.setMoneyType(priceDto.getMoneyType());
	
	
	this.productPriceRepository.save(productPrice);
		
	}

}
