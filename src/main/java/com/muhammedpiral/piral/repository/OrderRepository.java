package com.muhammedpiral.piral.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhammedpiral.piral.entity.account.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
