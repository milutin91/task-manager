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

        createEmployeeDTO.setFullName(employee.getFullName());
        createEmployeeDTO.setEmail(employee.getEmail());
        createEmployeeDTO.setPhoneNumber(employee.getPhoneNumber());
        createEmployeeDTO.setDateOfBirth(employee.getDateOfBirth());
        createEmployeeDTO.setMonthlySalary(employee.getMonthlySalary());

        return createEmployeeDTO;
    }

    public Employee mapEmployeeUpdateDtoToEntity(Employee employee, CreateEmployeeDTO employeeDTO) {
        employee.setFullName(employeeDTO.getFullName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setMonthlySalary(employeeDTO.getMonthlySalary());

        return employee;
    }
}
