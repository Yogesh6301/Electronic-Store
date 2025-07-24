package com.example.electronics.service;

import com.example.electronics.dto.CategoryDto;
import com.example.electronics.dto.PageableResponse;

public interface CategoryService {
	
	CategoryDto create(CategoryDto categoryDto);

	CategoryDto update(CategoryDto categoryDto, String categoryId);

	void delete(String categoryId);

	PageableResponse<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir);

	CategoryDto get(String categoryId);



}
