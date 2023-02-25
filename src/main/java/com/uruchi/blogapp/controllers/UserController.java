package com.uruchi.blogapp.controllers;

import com.uruchi.blogapp.models.User;
import com.uruchi.blogapp.payloads.ApiResponse;
import com.uruchi.blogapp.payloads.UserDto;
import com.uruchi.blogapp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto) {
        User createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

    }

    @PostMapping("/")
    public ResponseEntity<User> getUser( @RequestBody UserDto userDto) {
        User createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable("userId") Long userId, @RequestBody UserDto userDto) {
        User updatedUser = this.userService.updatetUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);

    }
    @GetMapping("/getallUsers")
    public ResponseEntity<?> getAllUsers() {

        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getSingleUser(@PathVariable Long userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }


}