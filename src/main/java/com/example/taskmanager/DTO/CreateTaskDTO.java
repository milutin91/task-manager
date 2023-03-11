package com.example.taskmanager.DTO;

import com.example.taskmanager.model.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class CreateTaskDTO {
        private String title;
        private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime dueDate;
        private Employee assignee;

    public CreateTaskDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "CreateTaskDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", assignee=" + assignee +
                '}';
    }
}
