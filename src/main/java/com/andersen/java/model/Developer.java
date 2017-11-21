package com.andersen.java.model;

import java.math.BigDecimal;
import java.util.Set;

public class Developer {

    private static Long currentId = 0L;
    private Long id;
    private String firstName;
    private String lastName;
    private String speciality;
    private Set<Skill> skills;
    private BigDecimal salary;

    public Developer(String firstName, String lastName, String speciality, Set<Skill> skills, BigDecimal salary) {
        currentId += 1;
        this.id = currentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.skills = skills;
        this.salary = salary;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }
}