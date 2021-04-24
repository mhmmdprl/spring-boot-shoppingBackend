package com.muhammedpiral.piral.rest.restProduct;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedpiral.piral.entity.product.dto.ProductPriceDto;
import com.muhammedpiral.piral.service.ProductPriceService;

@RestController
@RequestMapping("/products/price")
public class ProductPriceRestController {

	private ProductPriceService productPriceService;

	@PutMapping("/{uuid}")
	ResponseEntity<String> updatePrice(@PathVariable UUID uuid, @RequestBody ProductPriceDto productPriceDto) {

		this.productPriceService.updateProductPrice(productPriceDto, uuid);

		return ResponseEntity.ok("Güncellendi!");

	}
}
