package com.example.electronics.serviceImpl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.electronics.dto.CategoryDto;
import com.example.electronics.dto.PageableResponse;
import com.example.electronics.dto.UserDto;
import com.example.electronics.entity.Category;
import com.example.electronics.entity.User;
import com.example.electronics.exception.ResourceNotFoundException;
import com.example.electronics.repository.CategoryRepository;
import com.example.electronics.service.CategoryService;
import com.example.electronics.utility.Helper;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public CategoryDto create(CategoryDto categoryDto) {
		
		
		String categoryId = UUID.randomUUID().toString();
		categoryDto.setCategoryId(categoryId);
		Category category = modelmapper.map(categoryDto, Category.class);
		Category savedCategory = categoryRepository.save(category);

		CategoryDto updateddto = modelmapper.map(savedCategory, CategoryDto.class);
		return updateddto;
	}

	@Override
	public CategoryDto update(CategoryDto categoryDto, String categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not found with Id Exception"));

		category.setTitle(categoryDto.getTitle());
		category.setDescription(categoryDto.getDescription());
		category.setCoverImage(categoryDto.getCoverImage());

		Category updatedCategory = categoryRepository.save(category);
		CategoryDto updatedCategoryDto = modelmapper.map(updatedCategory, CategoryDto.class);

		return updatedCategoryDto;
	}

	@Override
	public void delete(String categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not found with Id Exception"));
	}

	@Override
	public PageableResponse<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

		Page<Category> page = categoryRepository.findAll(pageable);

		PageableResponse<CategoryDto> response = Helper.getPageableResponse(page, CategoryDto.class);
		return response;
	}

	@Override
	public CategoryDto get(String categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not found with Id Exception"));

		CategoryDto updateddto = modelmapper.map(category, CategoryDto.class);
		return updateddto;
	}

}
