package com.example.taskmanager.service;

import com.example.taskmanager.DTO.CreateTaskDTO;
import com.example.taskmanager.DTO.TeamDTO;
import com.example.taskmanager.mapper.TeamMapper;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.Team;
import com.example.taskmanager.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamMapper teamMapper;

    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        List<TeamDTO> teamDTOS = new ArrayList<>();
        for (Team team : teams) {
            teamDTOS.add(teamMapper.mapEntityToDto(team));
        }
        return teamDTOS;
    }
}
