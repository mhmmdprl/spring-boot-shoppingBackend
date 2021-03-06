package com.muhammedpiral.piral.rest.restPay;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedpiral.piral.entity.account.Order;
import com.muhammedpiral.piral.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderListRestController {
	
	
	@Autowired
	private OrderService orderListService;

	@PostMapping("/{uuid}")
	public ResponseEntity<Order> addToBasket(@PathVariable UUID uuid, @RequestParam(value = "id") Long[] id) {

		return ResponseEntity.ok(this.orderListService.saveOrderList(uuid, id));
	}



}
