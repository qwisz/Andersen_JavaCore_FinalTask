package com.andersen.java.model;

public class Skill implements Identifier {

    private Long id;
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  id + ";" + name;
    }
}
