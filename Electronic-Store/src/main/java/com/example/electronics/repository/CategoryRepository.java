package com.example.electronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electronics.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category, String>{

}
