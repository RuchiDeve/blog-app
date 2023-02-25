package com.uruchi.blogapp.services;

import com.uruchi.blogapp.payloads.CommentDto;
import com.uruchi.blogapp.serviceImp.CommentServiceImp;


public interface CommentService{
    CommentDto createComment(CommentDto commentDto, Long postId);
   void deleteComment(Long commentId);

}
