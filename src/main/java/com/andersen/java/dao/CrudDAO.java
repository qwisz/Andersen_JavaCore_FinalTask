package com.andersen.java.dao;

import com.andersen.java.model.Identifier;
import com.andersen.java.model.Skill;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public interface CrudDAO<T extends Identifier> {

    T save(T entity) throws IOException;

    void delete(Long id) throws IOException;

    String read(Long id) throws IOException;

    boolean isExist(Long id) throws IOException;

    boolean update(Long id, T entity) throws IOException;

    default T save(T entity, Path path, Path pathId) throws IOException {
        Objects.requireNonNull(entity);

        Long oldId = Long.parseLong(Files.readAllLines(pathId).get(0));

        Long currentId = oldId + 1;
        entity.setId(currentId);

        List<String> ids = Collections.singletonList(currentId.toString());
        Files.write(pathId, ids, StandardCharsets.UTF_8);

        List<String> lines = Collections.singletonList(entity.toString());
        Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

        return entity;
    }

    default String read(Long id, Path path) throws IOException {
        Objects.requireNonNull(id);

        List<String> skills = Files.readAllLines(path);
        skills.removeIf(s -> s.equals(""));
        String result = null;

        for (String s : skills) {
            if (s.split(";")[0].equals(id.toString())) {
                result = s;
                break;
            }
        }

        return result;
    }

    default boolean update(Long id, T entity, Path path) throws IOException {
        Objects.requireNonNull(id);
        Objects.requireNonNull(entity);

        List<String> entities = Files.readAllLines(path);
        String oldEntityString;

        for (String s : entities) {
            if (s.split(";")[0].equals(id.toString())) {
                oldEntityString = s;
                entity.setId(id);
                Files.write(path,
                        new String(Files.readAllBytes(path), StandardCharsets.UTF_8)
                                .replace(oldEntityString, entity.toString())
                                .getBytes(StandardCharsets.UTF_8));
                return true;
            }
        }
        return false;
    }

    default void delete(Long id, Path path) throws IOException {
        Objects.requireNonNull(id);

        List<String> skills = Files.readAllLines(path);
        String oldSkillString;

        for (String s : skills) {
            if (s.split(";")[0].equals(id.toString())) {
                oldSkillString = s;
                Files.write(path,
                        new String(Files.readAllBytes(path), StandardCharsets.UTF_8)
                                .replace(oldSkillString, "")
                                .getBytes(StandardCharsets.UTF_8));
                break;
            }
        }
    }

    default boolean isExist(Long id, Path path) throws IOException {
        Objects.requireNonNull(id);

        List<String> skills = Files.readAllLines(path);
        skills.removeIf(s -> s.equals(""));

        for (String s : skills) {
            if (s.split(";")[0].equals(id.toString())) {
                return true;
            }
        }

        return false;
    }
}
