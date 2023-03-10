package com.uruchi.blogapp.payloads;

import com.uruchi.blogapp.models.Category;
import com.uruchi.blogapp.models.Comment;
import com.uruchi.blogapp.models.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

public class PostDto {
    private Long postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private CategoryDto category;

    private UserDto user;
    private Set<CommentDto> comments=new HashSet<>();

    //private String imageName = "default.png";

}
