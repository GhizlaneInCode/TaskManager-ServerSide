package com.example.taskmanager.mappers;

import com.example.taskmanager.dto.requests.UserRequestDto;
import com.example.taskmanager.dto.responses.UserResponseDto;
import com.example.taskmanager.entities.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    List<UserResponseDto> mapUsers(List<User> users);

    Set<UserResponseDto> mapUsers(Set<User> users);

    @Mapping(target = "id", ignore = true)
    User requestToEntity(UserRequestDto userRequest);



    UserResponseDto entityToResponse(User user);
}
