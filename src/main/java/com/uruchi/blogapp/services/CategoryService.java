package com.uruchi.blogapp.services;

import com.uruchi.blogapp.models.Category;
import com.uruchi.blogapp.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
    CategoryDto getCategory(Long categoryId);
    List<CategoryDto> getCategories();
    void deleteCategory(Long categoryId);

}
