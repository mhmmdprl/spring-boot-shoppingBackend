package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.Order;

public interface OrderService {
	
	Order saveOrderList(UUID uuid,Long[] productIds);

}
