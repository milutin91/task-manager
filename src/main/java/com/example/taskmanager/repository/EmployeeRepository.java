package com.example.taskmanager.repository;

import com.example.taskmanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByFullName(String fullName);
}
