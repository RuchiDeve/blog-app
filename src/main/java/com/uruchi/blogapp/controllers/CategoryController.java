package com.uruchi.blogapp.controllers;

import com.uruchi.blogapp.models.Category;
import com.uruchi.blogapp.payloads.ApiResponse;
import com.uruchi.blogapp.payloads.CategoryDto;
import com.uruchi.blogapp.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto cateogDto) {
        CategoryDto createCategory = this.categoryService.createCategory(cateogDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);

    }

    //update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryId,
                                                      @PathVariable Long catId) {
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryId, catId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long catId) {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<>(new ApiResponse("category is deleted successfully!!", true)
                , HttpStatus.OK);
    }
        //get
        @GetMapping("/{catId}")
        public ResponseEntity<CategoryDto> geteCategory(@PathVariable Long catId) {
            CategoryDto categoryDto = this.categoryService.getCategory(catId);
            return new ResponseEntity<>(categoryDto, HttpStatus.OK);
        }
        //get all

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> geteCategories() {
        List<CategoryDto> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);

}
}