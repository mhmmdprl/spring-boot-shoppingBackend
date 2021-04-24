package com.muhammedpiral.piral.entity.product;

import java.util.List;

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

import com.muhammedpiral.piral.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "p_detail")
public class ProductDetail extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@SequenceGenerator(name = "seq_p_detail",allocationSize = 1)
	@GeneratedValue(generator = "seq_p_detail",strategy = GenerationType.SEQUENCE)
	private Long id;
	

	@Column(name="description")
	private String 	description;

	@ElementCollection
	private List<String> itemByItemComments;


	@OneToOne@JoinColumn(name = "product_id")
	private Product product;

}
