package com.example.electronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electronics.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>
{
}
