package com.andersen.java.Models;

public class Skill {

    private static Long currentId = 0L;
    private Long id;
    private String name;

    public Skill(String name) {
        currentId += 1;
        this.id = currentId;
        this.name = name;
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
}
