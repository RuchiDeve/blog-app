package com.uruchi.blogapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(name = "post_title",length = 100, nullable = false)
    private String postTitle;
    @Column(length = 10000)
    private String Content;
    private String imageName;
    private Date addedDate;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<Comment> comments=new HashSet<>();

//    public void setImageName(String s) {
//    }

    //public void AddedDate(Date date) {

    }

