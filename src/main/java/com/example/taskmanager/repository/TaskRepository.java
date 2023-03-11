package com.example.taskmanager.repository;

import com.example.taskmanager.DTO.EmployeeForTopFiveDTO;
import com.example.taskmanager.model.Employee;
import com.example.taskmanager.model.Task;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
public interface TaskRepository extends JpaRepository<Task, Integer> {
@Query(value = "SELECT assignee from tasks\n" +
        "WHERE YEAR(due_date) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
        "AND MONTH(due_date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
        "\tGROUP BY assignee\n" +
        "\tORDER BY count(*) desc\n" +
        "    limit 5;", nativeQuery = true)
    List<Integer> top5();

    List<Task> findByDueDateGreaterThan(LocalDateTime now);
}
