package com.andersen.java.dao;

import com.andersen.java.model.Project;
import com.andersen.java.model.Team;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProjectDAO implements CrudDAO<Project> {
    private final static Path PATH = Paths.get("src/main/resources/projects.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/projectsId.txt");

    @Override
    public Project save(Project entity) throws IOException {
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
    public boolean update(Long id, Project entity) throws IOException {
        return update(id, entity, PATH);
    }
}
