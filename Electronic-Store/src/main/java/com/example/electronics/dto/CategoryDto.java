package com.example.electronics.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {
	
	
	private String categoryId;

	@NotBlank(message = "Title is required")
	@Size(min = 4, message = "Title must be at least 4 characters long")
	private String title;

	@NotBlank(message = "Description is required")
	@Size(min = 10, message = "Description must be at least 10 characters long")
	private String description;

	private String coverImage;

	// No-args constructor
	public CategoryDto() {
	}

	// All-args constructor
	public CategoryDto(String categoryId, String title, String description, String coverImage) {
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.coverImage = coverImage;
	}

	// Getters and Setters
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
}
