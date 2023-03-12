package com.example.taskmanager.mapper;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.DTO.EmployeeForTopFiveDTO;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.EmployeeRepository;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    public Task matDtoToEntity(TaskDTO taskDTO){
        Task task = new Task();

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setAssignee(taskDTO.getAssignee());

        return task;
    }

    public TaskDTO mapEntityToDto(Task task){
         TaskDTO taskDTO = new TaskDTO();

         taskDTO.setTaskId(task.getTaskId());
         taskDTO.setTitle(task.getTitle());
         taskDTO.setDescription(task.getDescription());
         taskDTO.setDueDate(task.getDueDate());
         taskDTO.setAssignee(task.getAssignee());

         return taskDTO;
    }

    public Task mapDtoToEntityUpdate(Task task, TaskDTO taskDTO){
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setAssignee(taskDTO.getAssignee());

        return task;
    }

    public EmployeeForTopFiveDTO mapTopEntityToDto(Integer employee){

        EmployeeForTopFiveDTO employeeForTopFiveDTO = new EmployeeForTopFiveDTO();
        employeeForTopFiveDTO.setEmployee(employeeRepository.findById(employee).get());

        return employeeForTopFiveDTO;
    }
}
