package com.example.taskmanager.mapper;

import com.example.taskmanager.DTO.CreateTaskDTO;
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

    public EmployeeForTopFiveDTO mapTopEntityToDto(Integer employee){

        EmployeeForTopFiveDTO employeeForTopFiveDTO = new EmployeeForTopFiveDTO();

        employeeForTopFiveDTO.setEmployee(employeeRepository.findById(employee).get());
//        employeeForTopFiveDTO.setEmployee(employee.getHowMany());

        return employeeForTopFiveDTO;
    }
}
