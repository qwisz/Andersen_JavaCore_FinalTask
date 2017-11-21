package com.andersen.java.Models;

import java.util.Set;

public class Team {

    private static Long currentId = 0L;
    private Long id;
    private String name;
    private Set<Developer> developers;

    public Team(String name, Set<Developer> developers) {
        currentId += 1;
        this.id = currentId;
        this.name = name;
        this.developers = developers;
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

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }
}
