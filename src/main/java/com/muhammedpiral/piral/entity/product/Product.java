package com.muhammedpiral.piral.entity.product;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.muhammedpiral.piral.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted='0'")

public class Product extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@SequenceGenerator(name = "seq_product", allocationSize = 1)
	@GeneratedValue(generator = "seq_product", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "NAME")
	private String name;

	private String category;

	@Column(name = "available")
	private Long available;

	@Column(name = "ACTİVE")
	private boolean active;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "IMAGES")
	@ElementCollection
	private List<String> images;

	@OneToOne(targetEntity = ProductDetail.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUCT_DETAIL_ID")
	private ProductDetail productDetails;

	@OneToOne(targetEntity = ProductPrice.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id")
	private ProductPrice productPrice;

}
