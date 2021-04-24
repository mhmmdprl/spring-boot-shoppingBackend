package com.muhammedpiral.piral.entity.account;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.muhammedpiral.piral.entity.product.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "basket")
public class BasketList {

	
	
	@Id
	@SequenceGenerator(name = "basket_id",allocationSize = 1)
	@GeneratedValue(generator = "basket_id",strategy = GenerationType.SEQUENCE)
	private Long basketId;
	
	private double totalBasketPrice;

	@OneToMany(targetEntity = Product.class)
	private List<Product> products;
	
	@ManyToOne(targetEntity = Users.class,fetch = FetchType.LAZY)
	private Users user;
	
}
