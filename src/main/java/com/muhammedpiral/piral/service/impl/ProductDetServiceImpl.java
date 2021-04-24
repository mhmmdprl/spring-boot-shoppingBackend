package com.muhammedpiral.piral.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.product.ProductDetail;
import com.muhammedpiral.piral.entity.product.dto.ProductDetailDto;
import com.muhammedpiral.piral.repository.ProductDetailRepository;
import com.muhammedpiral.piral.repository.ProductRepository;
import com.muhammedpiral.piral.service.ProductDetService;


@Service
public class ProductDetServiceImpl implements ProductDetService {

	@Autowired
	private ProductDetailRepository productDetRepository ;
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Override
	public void updateProductDet(ProductDetailDto detailDto, UUID uuid) {
		
	ProductDetail productDetail= this.productDetRepository.findByProductId( this.productRepository.findByUuid(uuid).getId()); 
	
	productDetail.setItemByItemComments(detailDto.getItemByItemComments());
	productDetail.setDescription(detailDto.getExplanation());
	productDetail.setUpdatedDate(new Date());
	this.productDetRepository.save(productDetail);
		
	}

}
