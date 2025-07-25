package com.example.electronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electronics.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
}

