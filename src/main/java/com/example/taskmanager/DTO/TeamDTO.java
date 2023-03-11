package com.example.taskmanager.DTO;

public class TeamDTO {
    private String teamName;

    public TeamDTO() {
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "teamName='" + teamName + '\'' +
                '}';
    }
}
