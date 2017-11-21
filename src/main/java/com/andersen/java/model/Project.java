package com.andersen.java.model;

import java.util.Set;

public class Project {

    private static Long currentId = 0L;
    private Long id;
    private String name;
    private Set<Team> teams;

    public Project(String name, Set<Team> teams) {
        currentId += 1;
        this.id = currentId;
        this.name = name;
        this.teams = teams;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
