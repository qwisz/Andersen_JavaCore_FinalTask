package com.andersen.java.Models;

import java.util.Set;

public class Customer {

    private static Long currentId = 0L;
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private Set<Project> projects;

    public Customer(String firstName, String lastName, String address, Set<Project> projects) {
        currentId += 1;
        this.id = currentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
