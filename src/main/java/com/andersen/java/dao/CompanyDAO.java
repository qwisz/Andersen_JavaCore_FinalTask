package com.andersen.java.dao;

import com.andersen.java.model.Company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompanyDAO implements CrudDAO<Company>{
    private final static Path PATH = Paths.get("src/main/resources/companies.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/companiesId.txt");

    @Override
    public Company save(Company entity) throws IOException {
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
    public boolean update(Long id, Company entity) throws IOException {
        return update(id, entity, PATH);
    }

    @Override
    public boolean isExist(Long id) throws IOException {

        return isExist(id, PATH);
    }
}
