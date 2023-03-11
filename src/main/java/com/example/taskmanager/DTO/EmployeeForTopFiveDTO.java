package com.example.taskmanager.DTO;

import com.example.taskmanager.model.Employee;

public class EmployeeForTopFiveDTO {
    public Employee employee;

    public EmployeeForTopFiveDTO() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeForTopFiveDTO{" +
                "employee=" + employee +
                '}';
    }
}
