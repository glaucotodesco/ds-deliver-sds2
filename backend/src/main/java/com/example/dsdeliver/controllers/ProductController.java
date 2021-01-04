package com.example.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dsdeliver.dto.ProductDTO;
import com.example.dsdeliver.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
}
