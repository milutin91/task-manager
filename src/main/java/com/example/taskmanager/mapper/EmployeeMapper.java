package com.example.taskmanager.mapper;

import com.example.taskmanager.DTO.CreateEmployeeDTO;
import com.example.taskmanager.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee mapEmployeeDtoToEntity(CreateEmployeeDTO createEmployeeDTO){
        Employee employee = new Employee();

        employee.setFullName(createEmployeeDTO.getFullName());
        employee.setEmail(createEmployeeDTO.getEmail());
        employee.setPhoneNumber(createEmployeeDTO.getPhoneNumber());
        employee.setDateOfBirth(createEmployeeDTO.getDateOfBirth());
        employee.setMonthlySalary(createEmployeeDTO.getMonthlySalary());

        return employee;
    }

    public CreateEmployeeDTO mapEmployeeEntityToDto(Employee employee){
        CreateEmployeeDTO createEmployeeDTO = new CreateEmployeeDTO();

        createEmployeeDTO.setFullName(createEmployeeDTO.getFullName());
        createEmployeeDTO.setEmail(employee.getEmail());
        createEmployeeDTO.setPhoneNumber(createEmployeeDTO.getPhoneNumber());
        createEmployeeDTO.setDateOfBirth(employee.getDateOfBirth());
        createEmployeeDTO.setMonthlySalary(employee.getMonthlySalary());

        return createEmployeeDTO;
    }
}
