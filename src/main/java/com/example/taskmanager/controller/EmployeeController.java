package com.example.taskmanager.controller;

import com.example.taskmanager.DTO.EmployeeDTO;
import com.example.taskmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //employee add form
    @GetMapping("/employee/add")
    public String addEmployee(EmployeeDTO employeeDTO, Model model) {
        model.addAttribute("newEmployee", employeeDTO);
        return "add_employees";
    }

    //employee add action
    @PostMapping("/employee/create")
    public String createEmployee(@ModelAttribute("newEmployee") EmployeeDTO employeeDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add_employees";
        }
        employeeService.createEmployee(employeeDTO);

        return "redirect:/employee/all";
    }

    //read all employees
    @GetMapping("/employee/all")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "all_employees";
    }

    //Update employee form
    @GetMapping("/employee/update-form/{id}")
    public String updateEmployeeForm(@PathVariable("id") Integer id, Model model, EmployeeDTO employeeDTO) {
        model.addAttribute("id", id);
        model.addAttribute("updateEmployee", employeeDTO);
        model.addAttribute("updateEmployee", employeeService.findEmployee(id));

        return "update_employee";
    }

    //update employee action
    @PostMapping("/employee-update/{id}")
    public String updateEmployee(@PathVariable("id") Integer id,
                                 @ModelAttribute("updateEmployee") EmployeeDTO employeeDTO,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "update_employee";
        }
        employeeService.updateEmployee(id, employeeDTO);
        return "redirect:/employee/all";
    }

    //delete employee
    @GetMapping("/employee-delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/all";
    }
}
