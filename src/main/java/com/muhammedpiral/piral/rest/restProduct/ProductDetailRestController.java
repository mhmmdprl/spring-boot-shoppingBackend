package com.muhammedpiral.piral.rest.restProduct;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedpiral.piral.product.dto.ProductDetailDto;
import com.muhammedpiral.piral.service.ProductDetService;

@RestController
@RequestMapping("/products/detail")
public class ProductDetailRestController {

	@Autowired
	private ProductDetService productDetailService;
	
	@PutMapping("{uuid}")
	ResponseEntity<String> updateDetail(@RequestBody ProductDetailDto productDetailDto,@PathVariable UUID uuid){
		
		this.productDetailService.updateProductDet(productDetailDto, uuid);
		
		
		return ResponseEntity.ok("Güncellendi!");
	}
	
}
