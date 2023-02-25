package com.uruchi.blogapp.repositories;

import com.uruchi.blogapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long>{
}
