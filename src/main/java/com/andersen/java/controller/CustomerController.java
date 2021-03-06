package com.andersen.java.controller;

import com.andersen.java.dao.CustomerDAO;
import com.andersen.java.dao.ProjectDAO;
import com.andersen.java.model.Customer;
import com.andersen.java.model.Project;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CustomerController {

    private CustomerDAO customerDAO = new CustomerDAO();
    private ProjectDAO projectDAO = new ProjectDAO();

    public boolean create(String firstName, String lastName, String address, Set<Long> ids) throws IOException {
        Set<Project> projects = new HashSet<>();

        for (Long id: ids) {
            if (!projectDAO.isExist(id))
                return false;
            projects.add(projectDAO.getById(id));
        }
        customerDAO.save(new Customer(firstName, lastName, address, projects));
        return true;
    }

    public String read(Long id) throws IOException {
        return customerDAO.read(id);
    }

    public boolean update(Long id, String firstName, String lastName, String address, Set<Long> ids) throws IOException {
        Set<Project> projects = new HashSet<>();

        for (Long idd: ids) {
            if (!projectDAO.isExist(idd))
                return false;
            projects.add(projectDAO.getById(idd));
        }

        return customerDAO.update(id, new Customer(firstName, lastName, address, projects));
    }

    public void delete(Long id) throws IOException {
        customerDAO.delete(id);
    }

    public boolean isExist(Long id) throws IOException {
        return customerDAO.isExist(id);
    }
}
