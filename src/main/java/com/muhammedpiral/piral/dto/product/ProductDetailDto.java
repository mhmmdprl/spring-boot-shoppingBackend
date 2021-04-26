package com.muhammedpiral.piral.dto.product;

import java.util.List;

import com.muhammedpiral.piral.entity.product.ProductDetail;

import lombok.Data;

@Data
public class ProductDetailDto {

	private String 	explanation;

	private List<String> itemByItemComments;

	
	public ProductDetailDto(String explanation,List<String> itemByItemComments) {
		
		
		this.explanation=explanation;
		this.itemByItemComments=itemByItemComments;
		
	}
	
	
	public static ProductDetail of(ProductDetailDto productDetailDto) {
		
		ProductDetail productDetail=new ProductDetail();
		
		productDetail.setDescription(productDetailDto.getExplanation());
		
		productDetail.setItemByItemComments(productDetailDto.getItemByItemComments());
		
		return productDetail;
		
	}
}
