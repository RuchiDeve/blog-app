package com.uruchi.blogapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(name = "category_title", nullable = false, length = 50)
    private String categoryTitle;
    @Column(name = "catergory_description")
    private String categoryDescription;
//    @OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Post> posts = new ArrayList<>();


}
