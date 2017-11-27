package com.andersen.java.controller;

import com.andersen.java.dao.DeveloperDAO;
import com.andersen.java.dao.SkillDAO;
import com.andersen.java.model.Developer;
import com.andersen.java.model.Skill;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DeveloperController {

    private DeveloperDAO developerDAO = new DeveloperDAO();
    private SkillDAO skillDAO = new SkillDAO();

    public boolean create(String firstName, String lastName, String speciality,
                          Set<Long> ids, BigDecimal salary) throws IOException {

        Set<Skill> skills = getSkillsByIds(ids);

        developerDAO.save(new Developer(firstName, lastName, speciality, skills, salary));

        return true;
    }

    public String read(Long id) throws IOException {

        return developerDAO.read(id);
    }

    public boolean isExist(Long id) throws IOException {
        return developerDAO.isExist(id);
    }

    public boolean update(Long id, String firstName, String lastName, String speciality,
                          Set<Long> ids, BigDecimal salary) throws IOException {

        Set<Skill> skills = getSkillsByIds(ids);

        Developer developer = new Developer(firstName, lastName, speciality, skills, salary);
        return developerDAO.update(id, developer);
    }

    public void delete(Long id) throws IOException {
        developerDAO.delete(id);
    }

    private Set<Skill> getSkillsByIds(Set<Long> ids) throws IOException {
        Set<Skill> skills = new HashSet<>();

        for (Long id : ids) {
            skills.add(skillDAO.getById(id));
        }

        return skills;
    }
}