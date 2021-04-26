package com.muhammedpiral.piral.rest.restPay;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedpiral.piral.entity.account.Basket;
import com.muhammedpiral.piral.service.BasketListService;

@RestController
@RequestMapping("/basket")
public class BasketListRestController {

	@Autowired
	private BasketListService basketListService;

	@PostMapping("/{uuid}")
	public ResponseEntity<Basket> addToBasket(@PathVariable UUID uuid, @RequestParam(value = "id") Long[] id) {

		return ResponseEntity.ok(this.basketListService.saveBasketList(uuid, id));
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<String> deleteFromBasket(@PathVariable UUID uuid, @RequestParam(value = "id") Long id) {

		this.basketListService.deleteFromBasket(id, uuid);

		return ResponseEntity.ok("Sepetten Kaldırıldı!");

	}

}
