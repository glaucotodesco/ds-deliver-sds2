package com.example.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dsdeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
