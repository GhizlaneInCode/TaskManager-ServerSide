package com.example.taskmanager.mappers;

import com.example.taskmanager.dto.requests.TaskRequestDto;
import com.example.taskmanager.dto.responses.TaskResponseDto;
import com.example.taskmanager.entities.Task;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR) // obligatory to inject the mapper to the service
public interface TaskMapper {


    List<TaskResponseDto> mapTasks(List<Task> tasks);

    Set<TaskResponseDto> mapTasks(Set<Task> tasks);

    @Mapping(target = "id", ignore = true)
    Task requestToEntity(TaskRequestDto taskRequest);

    TaskResponseDto entityToResponse(Task task);




    //    TaskResponseDto entityToResponse(Task task);
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "completed", expression = "java(dto.getCompleted() != null && dto.getCompleted())")
//    Task requestToEntity(TaskRequestDto requestDto);
//
//
//    // Update existing entity (PATCH partial update)
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateEntity(TaskRequestDto dto, @MappingTarget Task task);


}
