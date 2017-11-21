package com.andersen.java.service;

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

public class SkillService {

    private final static Path PATH = Paths.get("src/main/resources/skills.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/skillsId.txt");

    public Skill create(String name) throws IOException {
        Objects.requireNonNull(name);

        Long oldId = Long.parseLong(Files.readAllLines(PATH_ID).get(0));

        Long currentId = oldId + 1;
        Skill skill = new Skill(currentId, name);

        List<String> ids = Collections.singletonList(currentId.toString());
        Files.write(PATH_ID, ids, StandardCharsets.UTF_8);

        List<String> lines = Collections.singletonList(skill.toString());
        Files.write(PATH, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

        System.out.println("Skill is created");
        return skill;
    }

    public Skill read(Long id) throws IOException {

        List<String> skills = Files.readAllLines(PATH);
        Skill result = null;

        for (String s : skills) {
            if (s.split(";")[0].equals(id.toString())) {
//                System.out.println(s.split(";")[0] + ";" + s.split(";")[1]);
                String name = s.split(";")[1];
                result = new Skill(id, name);
                break;
            }
        }

        if (result == null) {
            throw new RuntimeException("Skill with such id doesn't exist");
        }

        System.out.println(result);
        return result;
    }

    public void update(Long id, String name) throws IOException {
        List<String> skills = Files.readAllLines(PATH);
        Skill newSkill = null;
        String oldSkillString;

        for (String s : skills) {
            if (s.split(";")[0].equals(id.toString())) {
                oldSkillString = s;
                newSkill = new Skill(id, name);
                Files.write(PATH,
                        new String(Files.readAllBytes(PATH), StandardCharsets.UTF_8)
                                .replace(oldSkillString, newSkill.toString())
                                .getBytes(StandardCharsets.UTF_8));
                break;
            }
        }
        if (newSkill != null)
            System.out.println("Skill is updated");
        else
            System.out.println("Skill with such id doesn't exist");
    }

    public void delete(Long id) throws IOException {
        List<String> skills = Files.readAllLines(PATH);
        String oldSkillString = null;

        for (String s : skills) {
            if (s.split(";")[0].equals(id.toString())) {
                oldSkillString = s;
                Files.write(PATH,
                        new String(Files.readAllBytes(PATH), StandardCharsets.UTF_8)
                                .replace(oldSkillString, "")
                                .getBytes(StandardCharsets.UTF_8));
                break;
            }
        }
        if (oldSkillString != null)
            System.out.println("Skill is deleted");
        else
            System.out.println("Skill with such id doesn't exist");
    }
}
