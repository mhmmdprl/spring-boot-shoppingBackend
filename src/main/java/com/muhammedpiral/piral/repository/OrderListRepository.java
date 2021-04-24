package com.muhammedpiral.piral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhammedpiral.piral.entity.account.OrderList;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {

}
