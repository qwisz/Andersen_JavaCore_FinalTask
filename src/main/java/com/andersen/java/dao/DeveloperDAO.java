package com.andersen.java.dao;

import com.andersen.java.model.Developer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeveloperDAO implements CrudDAO<Developer> {

    private final static Path PATH = Paths.get("src/main/resources/developers.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/developersId.txt");

    @Override
    public Developer save(Developer entity) throws IOException {

        return save(entity, PATH, PATH_ID);
    }

    @Override
    public void delete(Long id) throws IOException {

    }

    @Override
    public Developer read(Long id) throws IOException {
        return null;
    }

    @Override
    public boolean update(Long id, Developer entity) throws IOException {
        return false;
    }
}
