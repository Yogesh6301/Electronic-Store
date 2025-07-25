package com.example.electronics.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.electronics.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	// search
	Page<Product> findByTitleContaining(String subtitle,Pageable pageable);

	Page<Product> findByLiveTrue(Pageable pageable);

}
