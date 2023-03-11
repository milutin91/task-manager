package com.example.taskmanager.controller;

import com.example.taskmanager.DTO.CreateTaskDTO;
import com.example.taskmanager.DTO.TeamDTO;
import com.example.taskmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeamController {
    @Autowired
    TeamService teamService;

    //    read all teams
    @GetMapping("/teams/all")
    public String getAllTeams(Model model){
        model.addAttribute("teams", teamService.getAllTeams());
        return "all_teams";
    }
}
