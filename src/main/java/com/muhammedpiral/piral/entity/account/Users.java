package com.muhammedpiral.piral.entity.account;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.muhammedpiral.piral.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users")
@Builder
@Where(clause="deleted='0'")
public class Users extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */


	@Id
	@SequenceGenerator(name = "users_id",allocationSize = 1)
	@GeneratedValue(generator = "users_id",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private Date birtOfDate;
	

	@OneToMany
	private List<OrderList> orderList;
	
	
	@OneToMany
	private List<BasketList> basketList;
	
	

}
