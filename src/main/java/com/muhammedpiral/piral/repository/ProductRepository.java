package com.muhammedpiral.piral.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.muhammedpiral.piral.entity.product.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByCategory(String category);
	
	@Modifying
	@Query("UPDATE Product p SET p.deleted='1' WHERE p.uuid=?1")
	@Transactional
	void delete(UUID uuid) ;
	
    Product findByUuid(UUID uuid);
	
	}


