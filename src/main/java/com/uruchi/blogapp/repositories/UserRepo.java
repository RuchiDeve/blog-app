package com.uruchi.blogapp.repositories;

import com.uruchi.blogapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
}
