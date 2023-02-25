package com.uruchi.blogapp.controllers;

import com.uruchi.blogapp.payloads.ApiResponse;
import com.uruchi.blogapp.payloads.CommentDto;
import com.uruchi.blogapp.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {
   @Autowired
   private CommentService commentService;
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto>createComment(@RequestBody CommentDto comment, @PathVariable Long postId){
       CommentDto CreateComment = this.commentService.createComment(comment, postId);
       return new ResponseEntity<>(CreateComment, HttpStatus.CREATED);
    }
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse>deleteComment(@PathVariable Long commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment deleted successfully", true), HttpStatus.OK);
    }

}
