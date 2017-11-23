package com.andersen.java.dao;

import java.io.IOException;

public interface CrudDAO<T> {

    T save(T entity) throws IOException;

    void delete(Long id) throws IOException;

    T read(Long id) throws IOException;

    boolean update(Long id, T entity) throws IOException;
}
