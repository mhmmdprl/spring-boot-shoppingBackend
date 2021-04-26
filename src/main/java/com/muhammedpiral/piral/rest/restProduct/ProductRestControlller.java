package com.muhammedpiral.piral.rest.restProduct;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedpiral.piral.dto.product.ProductDto;
import com.muhammedpiral.piral.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRestControlller {

	private final ProductService productService;

	@PostMapping
	public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {

		this.productService.saveProduct(productDto);

		return ResponseEntity.ok(productDto);
	}

	@GetMapping
	public List<ProductDto> findAll() {

		return this.productService.findAll();
	}

	@GetMapping("/category/{category}")
	public List<ProductDto> findByCategory(@PathVariable String category) {

		return this.productService.findByCategory(category);

	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<String> deleteProduct(@PathVariable UUID uuid) {

		this.productService.deleteProduct(uuid);

		return ResponseEntity.ok("Silindi!");
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto,@PathVariable UUID uuid) {

		this.productService.updateProduct(productDto,uuid);

		return ResponseEntity.ok("Güncellendi!");
	}

}
