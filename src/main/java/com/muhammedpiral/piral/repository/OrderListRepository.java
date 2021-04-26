package com.muhammedpiral.piral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhammedpiral.piral.entity.account.OrderProduct;

public interface OrderListRepository extends JpaRepository<OrderProduct, Long> {

}
