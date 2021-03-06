package com.andersen.java.dao;

import com.andersen.java.model.Skill;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SkillDAO implements CrudDAO<Skill> {

    private final static Path PATH = Paths.get("src/main/resources/skills.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/skillsId.txt");

    @Override
    public Skill save(Skill entity) throws IOException {
        return save(entity, PATH, PATH_ID);
    }

    @Override
    public void delete(Long id) throws IOException {
        delete(id, PATH);
    }

    @Override
    public String read(Long id) throws IOException {
        return read(id, PATH);
    }

    @Override
    public boolean update(Long id, Skill newSkill) throws IOException {
//        Objects.requireNonNull(id);
//        Objects.requireNonNull(newSkill);
//
//        List<String> skills = Files.readAllLines(PATH);
//        String oldSkillString;
//
//        for (String s : skills) {
//            if (s.split(";")[0].equals(id.toString())) {
//                oldSkillString = s;
//                newSkill.setId(id);
//                Files.write(PATH,
//                        new String(Files.readAllBytes(PATH), StandardCharsets.UTF_8)
//                                .replace(oldSkillString, newSkill.toString())
//                                .getBytes(StandardCharsets.UTF_8));
//                return true;
//            }
//        }
//        return false;

        return update(id, newSkill, PATH);
    }

    @Override
    public boolean isExist(Long id) throws IOException {

        return isExist(id, PATH);
    }

    public Skill getById(Long id) throws IOException {
        String skillString = read(id);

        String[] strings = skillString.split(";");

        Skill skill = new Skill(strings[1]);
        skill.setId(id);

        return skill;
    }
}
