package com.muhammedpiral.piral;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.muhammedpiral.piral.entity.account.Users;
import com.muhammedpiral.piral.entity.product.MoneyType;
import com.muhammedpiral.piral.entity.product.Product;
import com.muhammedpiral.piral.entity.product.ProductDetail;
import com.muhammedpiral.piral.entity.product.ProductPrice;
import com.muhammedpiral.piral.repository.ProductRepository;
import com.muhammedpiral.piral.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class PiralApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PiralApplication.class, args);
	}

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private final ProductRepository productRepository;

	private final UserRepository userRep;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

		Product product = new Product();
		ProductDetail productDetail = new ProductDetail();
		List<String> listItem = Arrays.asList("1-saglam", "2-su geçirmez");
		productDetail.setDescription("Aplle çelik kasa");
		productDetail.setItemByItemComments(listItem);
		// ************

		ProductPrice productPrice = new ProductPrice();

		productPrice.setMoneyType(MoneyType.USD);
		productPrice.setPrice(2990.0);

		// ************
		List<String> listImages = Arrays.asList("resim.png", "foto.jpg");
		product.setName("Apple");
		product.setAvailable(27L);
		product.setCreatedDate(new Date());
		product.setImages(listImages);
		product.setProductDetails(productDetail);
		product.setProductPrice(productPrice);
		Users user = new Users();
		user.setPassword(this.passwordEncoder.encode("123"));
		user.setUsername("piral");
		this.productRepository.save(product);
		this.userRep.save(user);

	}

}
