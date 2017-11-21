package com.andersen.java.service;

import com.andersen.java.model.Developer;
import com.andersen.java.model.Skill;

import java.math.BigDecimal;
import java.util.Set;

public class DeveloperService {

    SkillService skillService = new SkillService();

    public Developer create(String firstName, String lastName, String speciality, Set<Integer> skillsId, BigDecimal salary) {

        
    }
}
