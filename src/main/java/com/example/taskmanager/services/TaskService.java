package com.example.taskmanager.services;

import com.example.taskmanager.dto.requests.TaskRequestDto;
import com.example.taskmanager.dto.responses.TaskResponseDto;
import com.example.taskmanager.entities.Task;
import com.example.taskmanager.mappers.TaskMapper;
import com.example.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public List<TaskResponseDto> getAllTasks(){
        return taskMapper.mapTasks(taskRepository.findAll());
    }



    public TaskResponseDto getTaskById(Long id){

        Optional<Task> findTask = taskRepository.findById(id);

        if(!findTask.isPresent()){
            throw new RuntimeException("Task not found");
        }

        return taskMapper.entityToResponse(findTask.get());
    }


    public TaskResponseDto createTask(TaskRequestDto taskRequest){

        Optional<Task> findTask = taskRepository.findByTitle(taskRequest.getTitle());
        if(findTask.isPresent()){
            throw new RuntimeException("Task is already exist");
        }
        return taskMapper.entityToResponse(taskRepository.save(taskMapper.requestToEntity(taskRequest)));
    }


    public TaskResponseDto updateTask(Long id, TaskRequestDto taskRequest) {

        Optional<Task> findTask = taskRepository.findById(id);

        if (!findTask.isPresent()) {
            throw new RuntimeException("Task not found");
        }

        Task task = findTask.get();


        if(taskRequest.getTitle()!= null)
            task.setTitle(taskRequest.getTitle());

        if(taskRequest.getCompleted()!= null)
            task.setCompleted(taskRequest.getCompleted());

        task.setDescription(taskRequest.getDescription());

        Task saved = taskRepository.save(task);

        return taskMapper.entityToResponse(saved);
    }


    public void deleteTask(Long id) {

        Optional<Task> findTask = taskRepository.findById(id);

        if (!findTask.isPresent()) {
            throw new RuntimeException("Task not found");
        }

        taskRepository.deleteById(id);
    }
}

//    public List<TaskResponseDto> getAll() {
//        return taskRepository.findAll().stream().map(taskMapper::entityToResponse).toList();
//OR  return taskRepository.findAll().stream().map(task -> taskMapper.entityToResponse(task)).toList();
//    }
// :: methode reference it mean the lambda method .map(t -> taskMapper.entityToResponse(t))




//        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
//
//        // we use orElseThrow cs the findById returns an optional that force us to treat the nullable exception
//        return taskMapper.entityToResponse(task);
