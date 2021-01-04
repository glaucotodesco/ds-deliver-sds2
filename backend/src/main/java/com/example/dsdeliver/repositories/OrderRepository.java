package com.example.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
