package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.Basket;


@Service
public interface BasketService {

	
	Basket saveBasketList(UUID uuid,Long[] productIds);
	
	void deleteFromBasket(Long basketId,UUID uuid);
	
}
