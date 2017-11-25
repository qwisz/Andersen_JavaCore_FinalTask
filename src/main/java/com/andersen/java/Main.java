package com.andersen.java;

import com.andersen.java.dao.DeveloperDAO;
import com.andersen.java.view.SkillView;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        SkillView view = new SkillView();
        view.create();
        view.create();
        view.read();
        view.update();
        view.read();
        view.delete();
        view.read();
    }
}
