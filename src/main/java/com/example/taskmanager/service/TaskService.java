package com.example.taskmanager.service;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.DTO.EmployeeForTopFiveDTO;
import com.example.taskmanager.mapper.TaskMapper;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.matDtoToEntity(taskDTO);
        Task taskResponse = taskRepository.save(task);

        return taskMapper.mapEntityToDto(taskResponse);
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for (Task task : tasks) {
            taskDTOS.add(taskMapper.mapEntityToDto(task));
        }
        return taskDTOS;
    }

    public TaskDTO findTask(Integer id) {
        Task task = taskRepository.findById(id).get();
        return taskMapper.mapEntityToDto(task);
    }

    public TaskDTO updateTask(Integer id, TaskDTO taskDTO) {
        Task taskToUpdate = taskRepository.findById(id).get();
        taskToUpdate = taskMapper.mapDtoToEntityUpdate(taskToUpdate, taskDTO);
        Task taskResponse = taskRepository.save(taskToUpdate);
        return taskMapper.mapEntityToDto(taskResponse);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public List<EmployeeForTopFiveDTO> getTopFiveEmployees() {
        List<Integer> employees = taskRepository.findTopFiveEmployees();
        List<EmployeeForTopFiveDTO> employeeForTopFiveDTOS = new ArrayList<>();
        for (Integer employee : employees) {
            employeeForTopFiveDTOS.add(taskMapper.mapTopEntityToDto(employee));
        }
        return employeeForTopFiveDTOS;
    }

    public List<TaskDTO> getActiveTasks() {
        LocalDateTime now = LocalDateTime.now();
        List<Task> tasks = taskRepository.findByDueDateGreaterThan(now);
        List<TaskDTO> activeTaskDTOS = new ArrayList<>();
        for (Task task : tasks) {
            activeTaskDTOS.add(taskMapper.mapEntityToDto(task));
        }
        return activeTaskDTOS;
    }
}
