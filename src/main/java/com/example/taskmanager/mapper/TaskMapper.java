package com.example.taskmanager.mapper;

import com.example.taskmanager.DTO.CreateTaskDTO;
import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task matDtoToEntity(CreateTaskDTO taskDTO){
        Task task = new Task();

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setAssignee(taskDTO.getAssignee());

        return task;
    }

    public CreateTaskDTO mapEntityToDto(Task task){
         CreateTaskDTO taskDTO = new CreateTaskDTO();

         taskDTO.setTitle(task.getTitle());
         taskDTO.setDescription(task.getDescription());
         taskDTO.setDueDate(task.getDueDate());
         taskDTO.setAssignee(task.getAssignee());

         return taskDTO;
    }

    public Task mapDtoToEntityUpdate(Task task, CreateTaskDTO taskDTO){
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setAssignee(taskDTO.getAssignee());

        return task;
    }
}
