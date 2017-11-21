package com.andersen.java.model;

import java.util.Set;

public class Company {

    private static Long currentId = 0L;
    private Long id;
    private String name;
    private Set<Project> projects;

    public Company(String name, Set<Project> projects) {
        currentId += 1;
        this.id = currentId;
        this.name = name;
        this.projects = projects;
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
