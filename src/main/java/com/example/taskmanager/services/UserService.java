package com.example.taskmanager.services;

import com.example.taskmanager.dto.requests.UpdateRoleRequestDto;
import com.example.taskmanager.dto.requests.UserRequestDto;
import com.example.taskmanager.dto.responses.UserResponseDto;
import com.example.taskmanager.entities.Role;
import com.example.taskmanager.entities.User;
import com.example.taskmanager.mappers.UserMapper;
import com.example.taskmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDto UpdateUserRole(Long id, UpdateRoleRequestDto requestDto){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setRole(requestDto.getRole());
       return  userMapper.entityToResponse(userRepository.save(user));
    }


    public List<UserResponseDto> getAllUsers(){

        userRepository.findAll().forEach(u -> System.out.println("*******DB USER ID = " + u.getId()));
        return userMapper.mapUsers(userRepository.findAll());
    }

    public UserResponseDto UpdateUser(Long id, UserRequestDto requestDto){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));

        if(requestDto.getUsername() != null){
            user.setUsername(requestDto.getUsername());
        }

        return userMapper.entityToResponse(userRepository.save(user));
    }
}
