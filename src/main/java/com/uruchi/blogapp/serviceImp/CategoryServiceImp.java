package com.uruchi.blogapp.serviceImp;

import com.uruchi.blogapp.execeptions.ResourceNotFoundException;
import com.uruchi.blogapp.models.Category;
import com.uruchi.blogapp.payloads.CategoryDto;
import com.uruchi.blogapp.repositories.CategoryRepo;
import com.uruchi.blogapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).
                orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }
    @Override
    public CategoryDto getCategory(Long categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).
                orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        return this.modelMapper.map(cat, CategoryDto.class);

    }@Override
    public List<CategoryDto> getCategories() {
     List<Category>categories = this.categoryRepo.findAll();
     List<CategoryDto>catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat,
             CategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }
    @Override
    public void deleteCategory(Long categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).
                orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        this.categoryRepo.delete(cat);
    }
}
