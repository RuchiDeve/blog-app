package com.uruchi.blogapp.services;

import com.uruchi.blogapp.models.Post;
import com.uruchi.blogapp.payloads.PostDto;

import java.util.List;

public interface PostService {
    //CREAT
    PostDto createPost(PostDto postDto, Long userId, Long categoryId);
    //UPDATE
    PostDto updatePost(PostDto postDto, Long postId);
    //DELETE
    void deletePost(Long postId);
    //get all posts
    List<PostDto> getAllPost();
    //get single post
    PostDto getPostById(Long postId);
    //get all posts by category
    List<PostDto> getPostsByCategory(Long categoryId);
    //get all posts by user
    List<PostDto> getPostsByUser(Long userId);
    List<PostDto>searchPosts(String keyword);
}
