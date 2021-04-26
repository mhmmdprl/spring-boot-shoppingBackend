package com.muhammedpiral.piral.product.dto;

import com.muhammedpiral.piral.entity.product.MoneyType;
import com.muhammedpiral.piral.entity.product.ProductPrice;

import lombok.Data;

@Data
public class ProductPriceDto {

	private double price;

	private MoneyType moneyType;

	public ProductPriceDto(Double price, MoneyType moneyType) {

		this.price = price;
		this.moneyType = moneyType;
	}

	public static ProductPrice of(ProductPriceDto productPriceDto) {

		ProductPrice productPrice = new ProductPrice();

		productPrice.setMoneyType(productPriceDto.getMoneyType());

		productPrice.setPrice(productPriceDto.getPrice());

		return productPrice;

	}
}
