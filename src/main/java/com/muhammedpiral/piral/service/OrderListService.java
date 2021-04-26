package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.Order;

@Service
public interface OrderListService {
	
	Order saveOrderList(UUID uuid,Long[] productIds);

}
