package com.uruchi.blogapp.services;

import com.uruchi.blogapp.models.User;
import com.uruchi.blogapp.payloads.UserDto;


import java.util.List;

public interface UserService {
    User createUser(UserDto userDto);

    User updatetUser(UserDto userDto, Long userId);

    User getUserById(Long userId);

    List<User> getAllUsers();
    void deleteUser(Long userId);

}
