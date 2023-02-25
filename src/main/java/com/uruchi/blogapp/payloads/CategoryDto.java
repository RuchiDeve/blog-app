package com.uruchi.blogapp.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CategoryDto {
    private Long categoryId;
    @NotBlank
    @Size(min = 5, message = "Category title must be at least 5 characters long")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10, message = "Category description must be at least 10 characters long")
    private String categoryDescription;
}
