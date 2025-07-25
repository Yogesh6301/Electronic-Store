package com.example.electronics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electronics.entity.Cart;
import com.example.electronics.entity.User;

public interface CartRepository extends JpaRepository<Cart, String> {


    Optional<Cart> findByUser(User user);

}