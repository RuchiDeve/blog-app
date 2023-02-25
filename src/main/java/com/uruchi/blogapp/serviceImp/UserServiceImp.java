package com.uruchi.blogapp.serviceImp;

//import com.uruchi.blogapp.execeptions.NotFoundException;
//import com.uruchi.blogapp.execeptions.ResourceNotFoundException;
import com.uruchi.blogapp.execeptions.ResourceNotFoundException;
import com.uruchi.blogapp.models.User;
import com.uruchi.blogapp.payloads.UserDto;
import com.uruchi.blogapp.repositories.UserRepo;
import com.uruchi.blogapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserServiceImp implements UserService {
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
       // user.setPassword(userDto.getPassword());
        return userRepo.save(user);
//        User savedUser = this.userRepo.save(user);
//        return this.userToDto(savedUser);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepo.findAll();
    }

    @Override
    public User updatetUser(UserDto userDto, Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id ", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
      //  user.setPassword(userDto.getPassword());

        return userRepo.save(user);
    }

    //    public UserDto updatetUser(UserDto userDto, Long userId){
//        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException ("User", "id", userId));
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        User updatetUser = this.userRepo.save(user);
//        UserDto userDto1 = this.userToDto(updatetUser);
//        return userDto1;
//    }
    @Override

  public User getUserById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        return modelMapper.map(user, User.class);


//        return userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id ", userId));
//

        //User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException ("User", "id", userId));


    }

//    @Override
//    public List<UserDto> getAllUsers() {
//      List<User>users = this.userRepo.findAll();
//      List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
//        return userDtos;
//    }

    @Override
    public void deleteUser(Long userId) {
        User user = getUserById(userId);
//        User user = getUserById(userId);
        userRepo.delete(user);

    }

    public User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto userToDto(User user) {
       UserDto userDto = this.modelMapper.map(user, UserDto.class);

//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
        return userDto;

    }
}

