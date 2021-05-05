package com.muhammedpiral.piral.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.Order;
import com.muhammedpiral.piral.entity.account.Users;
import com.muhammedpiral.piral.entity.product.Product;
import com.muhammedpiral.piral.repository.OrderRepository;
import com.muhammedpiral.piral.repository.ProductRepository;
import com.muhammedpiral.piral.repository.UserRepository;
import com.muhammedpiral.piral.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderListRepo;
	
	
	@Override
	public Order saveOrderList(UUID uuid, Long[] productIds) {
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

		Order orderList = new Order();

		orderList.setProducts(products);
		orderList.setTotalPrice(totalPrice);
		orderList.setUserId(user);

		return this.orderListRepo.save(orderList);
	
	}

}
