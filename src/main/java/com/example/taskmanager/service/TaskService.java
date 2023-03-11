package com.example.taskmanager.service;

import com.example.taskmanager.DTO.CreateTaskDTO;
import com.example.taskmanager.DTO.EmployeeForTopFiveDTO;
import com.example.taskmanager.mapper.TaskMapper;
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

    public CreateTaskDTO findTask(Integer id) {
        Task task = taskRepository.findById(id).get();
        return taskMapper.mapEntityToDto(task);
    }

    public CreateTaskDTO updateTask(Integer id, CreateTaskDTO taskDTO) {
        Task taskToUpdate = taskRepository.findById(id).get();
        taskToUpdate = taskMapper.mapDtoToEntityUpdate(taskToUpdate, taskDTO);
        Task taskResponse = taskRepository.save(taskToUpdate);
        return taskMapper.mapEntityToDto(taskResponse);
    }

    public void deleteTask(Integer id) {
//        List<Task> tasks = taskRepository.findById(id).get().;
//        for (Task task : tasks) {
//            task.setAssignee(null);
//        }
        taskRepository.deleteById(id);
    }

    public List<EmployeeForTopFiveDTO> getTopFiveEmployees() {
//        List<Employee> employees = taskRepository.top5();
//        List<EmployeeForTopFiveDTO> employeeForTopFiveDTOS = new ArrayList<>();
//                for (Employee employee : employees) {
//            employeeForTopFiveDTOS.add(taskMapper.mapTopEntityToDto());
//        }
        List<Integer> employees = taskRepository.top5();
        List<EmployeeForTopFiveDTO> employeeForTopFiveDTOS = new ArrayList<>();
        for (Integer employee : employees) {
            employeeForTopFiveDTOS.add(taskMapper.mapTopEntityToDto(employee));
        }
        return employeeForTopFiveDTOS;
    }
}
