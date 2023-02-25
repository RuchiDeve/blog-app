package com.uruchi.blogapp.repositories;

import com.uruchi.blogapp.models.Category;
import com.uruchi.blogapp.models.Post;
import com.uruchi.blogapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    //List<Post> findByUserAndCategory(String title);


}
