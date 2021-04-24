package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.OrderList;

@Service
public interface OrderListService {
	
	OrderList saveOrderList(UUID uuid,Long[] productIds);

}
