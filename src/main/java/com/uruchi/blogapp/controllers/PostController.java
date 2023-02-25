package com.uruchi.blogapp.controllers;

import com.uruchi.blogapp.models.Post;
import com.uruchi.blogapp.payloads.ApiResponse;
import com.uruchi.blogapp.payloads.PostDto;
import com.uruchi.blogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable Long userId, @PathVariable Long categoryId) {
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Long userId) {
        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //get by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Long categoryId) {
        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost() {
        List<PostDto> allPost = this.postService.getAllPost();
        return new ResponseEntity<>(allPost, HttpStatus.OK);
    }
    //get post details by id

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostsById(@PathVariable Long postId) {
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
    }

    //Delete post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Long postId) {
        this.postService.deletePost(postId);
        return new ApiResponse("Post is deleted successfully!!", true);
    }

    //update post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> upDatePost(@RequestBody PostDto postDto, @PathVariable Long postId) {
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
    }

    //search post
//    @GetMapping("/posts/search/{keywords}")
//    public ResponseEntity<List<PostDto>> searchPostByTitle(@RequestParam String keywords) {
//        List<PostDto> result = this.postService.searchPosts(keywords);
//        return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
//    }
}
