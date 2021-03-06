package com.andersen.java.dao;

import com.andersen.java.model.Developer;
import com.andersen.java.model.Team;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class TeamDAO implements CrudDAO<Team> {
    private final static Path PATH = Paths.get("src/main/resources/teams.txt");
    private final static Path PATH_ID = Paths.get("src/main/resources/teamsId.txt");

    private DeveloperDAO developerDAO = new DeveloperDAO();

    @Override
    public Team save(Team entity) throws IOException {
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
    public boolean update(Long id, Team entity) throws IOException {
        return update(id, entity, PATH);
    }

    @Override
    public boolean isExist(Long id) throws IOException {

        return isExist(id, PATH);
    }

    public Team getById(Long id) throws IOException {
        String teamString = read(id);

        String[] strings = teamString.split(";");

        String name = strings[1];

        Set<Developer> developers = new HashSet<>();
        String[] developersIds = strings[2].split(",");
        for (String idString : developersIds) {
            developers.add(developerDAO.getById(Long.parseLong(idString)));
        }

        Team team = new Team(name, developers);
        team.setId(id);

        return team;
    }
}
