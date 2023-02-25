package com.uruchi.blogapp.serviceImp;

import com.uruchi.blogapp.execeptions.ResourceNotFoundException;
import com.uruchi.blogapp.models.Comment;
import com.uruchi.blogapp.models.Post;
import com.uruchi.blogapp.payloads.CommentDto;
import com.uruchi.blogapp.repositories.CommentRepo;
import com.uruchi.blogapp.repositories.PostRepo;
import com.uruchi.blogapp.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
@Service
@RequiredArgsConstructor
public class CommentServiceImp implements CommentService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Long postId) {
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId, "id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment newComment = this.commentRepo.save(comment);
        return this.modelMapper.map(newComment, CommentDto.class);

    }
    @Override
    public void deleteComment(Long commentId) {
        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId, "id", commentId));
        this.commentRepo.delete(comment);

    }
}
