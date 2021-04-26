package com.muhammedpiral.piral.dto.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.muhammedpiral.piral.entity.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

	private String name;

	private ProductPriceDto productPriceDto;
	
	private UUID uuid;

	private Long available;

	private Date createdDate;

	private ProductDetailDto productDetailsDto;

	private String category;

	@Builder.Default
	private List<String> images = new ArrayList<String>();

	public static ProductDto of(Product product) {
		ProductPriceDto productPriceDto = new ProductPriceDto(product.getProductPrice().getPrice(),
				product.getProductPrice().getMoneyType());
		ProductDto productDto = new ProductDto();
		ProductDetailDto productDetailDto = new ProductDetailDto(product.getProductDetails().getDescription(),
				product.getProductDetails().getItemByItemComments());
		productDto.setName(product.getName());
		productDto.setProductPriceDto(productPriceDto);
		productDto.setAvailable(product.getAvailable());
		productDto.setCreatedDate(product.getCreatedDate());
		productDto.setImages(product.getImages());
		productDto.setProductDetailsDto(productDetailDto);
		productDto.setCategory(product.getCategory());
		return productDto;
	}

}
