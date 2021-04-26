package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.OrderProduct;

@Service
public interface OrderListService {
	
	OrderProduct saveOrderList(UUID uuid,Long[] productIds);

}
