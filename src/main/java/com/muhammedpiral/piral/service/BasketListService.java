package com.muhammedpiral.piral.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.BasketList;


@Service
public interface BasketListService {

	
	BasketList saveBasketList(UUID uuid,Long[] productIds);
	
	void deleteFromBasket(Long basketId,UUID uuid);
	
}
