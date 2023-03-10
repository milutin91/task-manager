package com.example.taskmanager.controller;

import com.example.taskmanager.DTO.CreateEmployeeDTO;
import com.example.taskmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

//employee add form
    @GetMapping("/employee/add")
    public String addEmployee(CreateEmployeeDTO employeeDTO, Model model) {
        model.addAttribute("newEmployee", employeeDTO);
        return "add_employees";
    }
//employee add post
    @PostMapping("/employee/create")
    public String createEmployee(@ModelAttribute("newEmployee") CreateEmployeeDTO createEmployeeDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "add_employees";
        }
        employeeService.createEmployee(createEmployeeDTO);

        return "redirect:/index";
    }

    @GetMapping("/employee/all")
    public String getAllEmployees(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "all_employees";
    }
}
