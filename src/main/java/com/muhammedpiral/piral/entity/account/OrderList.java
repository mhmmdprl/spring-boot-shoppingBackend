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

import com.muhammedpiral.piral.entity.BaseEntity;
import com.muhammedpiral.piral.entity.product.Product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "order")
public class OrderList extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "order_id",allocationSize = 1)
	@GeneratedValue(generator = "order_id",strategy = GenerationType.SEQUENCE)
	private Long orderId;
	
	private double totalPrice;

	@OneToMany(targetEntity = Product.class)
	private List<Product> products;
	
	@ManyToOne(targetEntity = Users.class,fetch = FetchType.LAZY)
	private Users userId;
	

}
