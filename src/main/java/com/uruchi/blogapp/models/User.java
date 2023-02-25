package com.uruchi.blogapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name", nullable = false, length = 50)
    private String name;

    private String email;

    private String password;

//    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Post> posts = new ArrayList<>();

}
