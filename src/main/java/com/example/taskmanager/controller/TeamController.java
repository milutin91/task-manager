package com.example.taskmanager.controller;

import com.example.taskmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
