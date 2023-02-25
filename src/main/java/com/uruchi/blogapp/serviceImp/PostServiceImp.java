package com.uruchi.blogapp.serviceImp;

import com.uruchi.blogapp.execeptions.ResourceNotFoundException;
import com.uruchi.blogapp.models.Category;
import com.uruchi.blogapp.models.Post;
import com.uruchi.blogapp.models.User;
import com.uruchi.blogapp.payloads.PostDto;
import com.uruchi.blogapp.repositories.CategoryRepo;
import com.uruchi.blogapp.repositories.PostRepo;
import com.uruchi.blogapp.repositories.UserRepo;
import com.uruchi.blogapp.services.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PostServiceImp implements PostService {

    private PostService postService;
    @Autowired

    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Long userId, Long categoryId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newpost = this.postRepo.save(post);
        return this.modelMapper.map(newpost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
        post.setPostTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Long postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
        this.postRepo.delete(post);

    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> allPost = this.postRepo.findAll();
        List<PostDto> postDtos = allPost.stream().map((post) -> this.modelMapper
                .map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Long categoryId) {
        Category cat = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post) ->
                this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;

    //search post
//    @Override
//    public List<PostDto> searchPosts(String keyword) {
//        List<Post> posts = this.postRepo.findByPostTitleContainingOrContentContaining(keyword, keyword);
//        // List<Post> posts = this.postRepo.(keyword, keyword, keyword, keyword);
//        List<PostDto> postDtos = posts.stream().map((post) ->
//                this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
//        return postDtos;
//
  }

}



