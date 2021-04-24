package com.muhammedpiral.piral.entity.product;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Entity
@Data
@Table(name = "product_price")
public class ProductPrice {
	@Id
	@SequenceGenerator(name = "seq_product_price",allocationSize = 1)
	@GeneratedValue(generator = "seq_product_price",strategy = GenerationType.SEQUENCE)
	private Long priceId;
	
	private double price;
	
	@Enumerated
	private MoneyType moneyType;
	
	@OneToOne@JoinColumn(name = "product_id")
	private Product product;

}
