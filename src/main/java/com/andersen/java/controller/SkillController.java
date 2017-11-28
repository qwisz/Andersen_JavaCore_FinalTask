package com.andersen.java.controller;

import com.andersen.java.dao.SkillDAO;
import com.andersen.java.model.Skill;

import java.io.IOException;
import java.util.Objects;

public class SkillController {

    private SkillDAO dao = new SkillDAO();

    public boolean create(String name) throws IOException {
        Skill skill = dao.save(new Skill(name));

        return skill != null;
    }

    public String read(Long id) throws IOException {
        return dao.read(id);
    }

    public boolean update(Long id, String name) throws IOException {
        return dao.update(id, new Skill(name));
    }

    public void delete(Long id) throws IOException {
        dao.delete(id);
    }

    public boolean isExist(Long id) throws IOException {
        return dao.isExist(id);
    }
}
