package com.muhammedpiral.piral.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.Basket;
import com.muhammedpiral.piral.entity.account.Users;
import com.muhammedpiral.piral.entity.product.Product;
import com.muhammedpiral.piral.repository.BasketRepository;
import com.muhammedpiral.piral.repository.ProductRepository;
import com.muhammedpiral.piral.repository.UserRepository;
import com.muhammedpiral.piral.service.BasketListService;

@Service
public class BasketListServiceImpl implements BasketListService {

	@Autowired
	private BasketRepository basketListRep;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Basket saveBasketList(UUID uuid, Long[] productIds) {

		Double totalPrice = 0.0;
		Users user = this.userRepository.findByUuid(uuid);
		List<Product> products = new ArrayList<Product>();

		for (Long productId : productIds) {

			Optional<Product> product = this.productRepository.findById(productId);
			product.get().setAvailable(product.get().getAvailable()-1);
			this.productRepository.save(product.get());
			totalPrice = totalPrice + product.get().getProductPrice().getPrice();
			products.add(product.get());
		}

		Basket basketList = new Basket();

		basketList.setProducts(products);
		basketList.setTotalBasketPrice(totalPrice);
		basketList.setUser(user);

		return this.basketListRep.save(basketList);
	}

	@Override
	public void deleteFromBasket(Long basketId, UUID uuid) {
		Product product=this.productRepository.findByUuid(uuid);
		product.setAvailable(product.getAvailable()+1);
		this.productRepository.save(product);
		this.basketListRep.deleteById(basketId);
	}

}
