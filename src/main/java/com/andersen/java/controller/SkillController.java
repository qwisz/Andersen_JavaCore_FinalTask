package com.andersen.java.controller;

import com.andersen.java.dao.SkillDAO;
import com.andersen.java.model.Skill;

import java.io.IOException;
import java.util.Objects;

public class SkillController {

    private SkillDAO dao = new SkillDAO();

    public boolean create(String name) throws IOException {
        Objects.requireNonNull(name);

        Skill skill = dao.save(new Skill(name));

        return skill != null;
    }

    public Skill read(String idString) throws IOException {
        Objects.requireNonNull(idString);

        Long id = Long.parseLong(idString);

        Skill skill = dao.read(id);

        return skill;
    }

    public boolean update(String idString, String name) throws IOException {

        Objects.requireNonNull(idString);
        Objects.requireNonNull(name);

        Long id = Long.parseLong(idString);
        Skill skill = new Skill(name);

        return dao.update(id, skill);
    }

    public void delete(String idString) throws IOException {
        Objects.requireNonNull(idString);

        Long id = Long.parseLong(idString);

        dao.delete(id);
    }
}
