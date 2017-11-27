package com.andersen.java.dao;

import com.andersen.java.model.Developer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class DeveloperDAO implements CrudDAO<Developer> {

    private final static Path PATH = Paths.get("src/main/resources/developers.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/developersId.txt");

    @Override
    public Developer save(Developer entity) throws IOException {
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
    public boolean update(Long id, Developer entity) throws IOException {
        return update(id, entity, PATH);
    }

    @Override
    public boolean isExist(Long id) throws IOException {

        return isExist(id, PATH);
    }
}
