package com.example.taskmanager.mapper;

import com.example.taskmanager.DTO.EmployeeDTO;
import com.example.taskmanager.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee mapEmployeeDtoToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        employee.setFullName(employeeDTO.getFullName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setMonthlySalary(employeeDTO.getMonthlySalary());

        return employee;
    }

    public EmployeeDTO mapEmployeeEntityToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setFullName(employee.getFullName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        employeeDTO.setMonthlySalary(employee.getMonthlySalary());

        return employeeDTO;
    }

    public Employee mapEmployeeUpdateDtoToEntity(Employee employee, EmployeeDTO employeeDTO) {
        employee.setFullName(employeeDTO.getFullName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setMonthlySalary(employeeDTO.getMonthlySalary());

        return employee;
    }
}
