package com.example.taskmanager.mapper;

import com.example.taskmanager.DTO.TeamDTO;
import com.example.taskmanager.model.Team;
import com.example.taskmanager.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {
    @Autowired
    TeamRepository teamRepository;

    public Team mapDtoToEntity(TeamDTO teamDTO){
        Team team = new Team();

        team.setTeamName(teamDTO.getTeamName());

        return team;
    }

    public TeamDTO mapEntityToDto(Team team){
        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setTeamName(team.getTeamName());

        return teamDTO;
    }
}
