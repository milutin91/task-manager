package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
public interface TaskRepository extends JpaRepository<Task, Integer> {
@Query(value = "SELECT assignee, count(*) AS HowMany from tasks\n" +
        "WHERE YEAR(due_date) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
        "AND MONTH(due_date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
        "AND assignee IS NOT NULL\n" +
        "\tGROUP BY assignee\n" +
        "\tORDER BY HowMany desc\n" +
        "    limit 5;", nativeQuery = true)
    List<Integer> findTopFiveEmployees();

    List<Task> findByDueDateGreaterThan(LocalDateTime now);
}
