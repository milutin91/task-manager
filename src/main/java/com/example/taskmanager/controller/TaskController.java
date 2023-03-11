package com.example.taskmanager.controller;

import com.example.taskmanager.DTO.CreateEmployeeDTO;
import com.example.taskmanager.DTO.CreateTaskDTO;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    //task add form
    @GetMapping("/task/add")
    public String addTask(CreateTaskDTO taskDTO, Model model) {
        model.addAttribute("newTask", taskDTO);
        return "add_tasks";
    }

    //task add action
    @PostMapping("/task/create")
    public String createTask(@ModelAttribute("newTask") CreateTaskDTO taskDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "add_tasks";
        }

        taskService.createTask(taskDTO);

        return "redirect:/index";
    }
}
