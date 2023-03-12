package com.example.taskmanager.controller;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    //task add form
    @GetMapping("/task/add")
    public String addTask(TaskDTO taskDTO, Model model) {
        model.addAttribute("newTask", taskDTO);
        return "add_tasks";
    }

    //task add action
    @PostMapping("/task/create")
    public String createTask(@ModelAttribute("newTask") TaskDTO taskDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "add_tasks";
        }

        taskService.createTask(taskDTO);

        return "redirect:/task/all";
    }

//    read all tasks

    @GetMapping("/task/all")
    public String getAllTasks(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        return "all_tasks";
    }

    //Update task form
    @GetMapping("/task/update-form/{id}")
    public String updateTaskForm(@PathVariable("id") Integer id, Model model, TaskDTO taskDTO){
        model.addAttribute("id", id);
        model.addAttribute("updateTask", taskDTO);
        model.addAttribute("updateTask", taskService.findTask(id));

        return "update_task";
    }

    //update employee action
    @PostMapping("/task-update/{id}")
    public String updateTask(@PathVariable("id") Integer id,
                                 @ModelAttribute("updateTask") TaskDTO taskDTO,
                                 BindingResult result) {
        if(result.hasErrors()){
            return "update_task";
        }
        taskService.updateTask(id, taskDTO);
        return "redirect:/task/all";
    }

    //delete task
    @GetMapping("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Integer id) {
        taskService.deleteTask(id);
        return "redirect:/task/all";
    }

    //top 5 employees
    @GetMapping("/task/top-five")
    public String getTopFive(Model model){
        model.addAttribute("topFiveEmployees", taskService.getTopFiveEmployees());
        return "top_five_employees";
    }

    //active tasks
    @GetMapping("/task/active")
    public String getActiveTasks(Model model){
        model.addAttribute("activeTasks", taskService.getActiveTasks());
        return "active_tasks";
    }
}
