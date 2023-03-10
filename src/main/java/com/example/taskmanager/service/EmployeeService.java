package com.example.taskmanager.service;

import com.example.taskmanager.mapper.EmployeeMapper;
import com.example.taskmanager.DTO.CreateEmployeeDTO;
import com.example.taskmanager.model.Employee;
import com.example.taskmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    public CreateEmployeeDTO createEmployee(CreateEmployeeDTO createEmployeeDTO) {
        Employee employee = employeeMapper.mapEmployeeDtoToEntity(createEmployeeDTO);
        Employee employeeResponse = employeeRepository.save(employee);

        return employeeMapper.mapEmployeeEntityToDto(employeeResponse);
    }
}
