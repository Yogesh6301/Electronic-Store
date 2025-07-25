package com.example.electronics.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electronics.entity.Order;
import com.example.electronics.entity.User;

public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order> findByUser(User user);

	Page<Order> findAll(Pageable pageable);

	
}