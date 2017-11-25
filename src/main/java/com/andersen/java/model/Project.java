package com.andersen.java.model;

import java.util.Set;

public class Project implements Identifier {

    private Long id;
    private String name;
    private Set<Team> teams;

    public Project(String name, Set<Team> teams) {
        this.name = name;
        this.teams = teams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
