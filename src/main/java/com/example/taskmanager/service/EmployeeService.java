package com.example.taskmanager.service;

import com.example.taskmanager.mapper.EmployeeMapper;
import com.example.taskmanager.DTO.EmployeeDTO;
import com.example.taskmanager.model.Employee;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.mapEmployeeDtoToEntity(employeeDTO);
        Employee employeeResponse = employeeRepository.save(employee);

        return employeeMapper.mapEmployeeEntityToDto(employeeResponse);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDTOS.add(employeeMapper.mapEmployeeEntityToDto(employee));
        }
        return employeeDTOS;
    }

    public EmployeeDTO findEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id).get();
        return employeeMapper.mapEmployeeEntityToDto(employee);
    }

    public EmployeeDTO updateEmployee(Integer id, EmployeeDTO employeeDTO) {
        Employee employeeToUpdate = employeeRepository.findById(id).get();
        employeeToUpdate = employeeMapper.mapEmployeeUpdateDtoToEntity(employeeToUpdate, employeeDTO);
        Employee employeeResponse = employeeRepository.save(employeeToUpdate);
        return employeeMapper.mapEmployeeEntityToDto(employeeResponse);
    }

    public void deleteEmployee(Integer id) {
        List<Task> tasks = employeeRepository.findById(id).get().getTasks();
        for (Task task : tasks) {
            task.setAssignee(null);
        }
        employeeRepository.deleteById(id);
    }
}
