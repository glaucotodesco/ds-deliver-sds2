package com.example.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dsdeliver.dto.OrderDTO;
import com.example.dsdeliver.dto.ProductDTO;
import com.example.dsdeliver.entities.Order;
import com.example.dsdeliver.entities.OrderStatus;
import com.example.dsdeliver.entities.Product;
import com.example.dsdeliver.repositories.OrderRepository;
import com.example.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map( o -> new OrderDTO(o)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto){
		Order order = new Order(null,dto.getAddress(),dto.getLatitude(), dto.getLongitude(), Instant.now(),  OrderStatus.PENDING);
		
		for(ProductDTO prodDto: dto.getProducts()) {
			Product prod = productRepository.getOne(prodDto.getId());
			order.getProducts().add(prod);
		}
		
		order = repository.save(order);
		
		return new OrderDTO(order);
	}
	
	
	
	
	
}
