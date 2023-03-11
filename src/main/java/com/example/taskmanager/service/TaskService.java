package com.example.taskmanager.service;

import com.example.taskmanager.DTO.CreateEmployeeDTO;
import com.example.taskmanager.DTO.CreateTaskDTO;
import com.example.taskmanager.mapper.TaskMapper;
import com.example.taskmanager.model.Employee;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public CreateTaskDTO createTask(CreateTaskDTO taskDTO) {
        Task task = taskMapper.matDtoToEntity(taskDTO);
        Task taskResponse = taskRepository.save(task);

        return taskMapper.mapEntityToDto(taskResponse);
    }

    public List<CreateTaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<CreateTaskDTO> taskDTOS = new ArrayList<>();
        for (Task task : tasks) {
            taskDTOS.add(taskMapper.mapEntityToDto(task));
        }
        return taskDTOS;
    }
}
