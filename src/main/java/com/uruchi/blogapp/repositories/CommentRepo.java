package com.uruchi.blogapp.repositories;

import com.uruchi.blogapp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
