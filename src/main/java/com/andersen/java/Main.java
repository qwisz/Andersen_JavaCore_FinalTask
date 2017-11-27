package com.andersen.java;

import com.andersen.java.model.Developer;
import com.andersen.java.view.DeveloperView;
import com.andersen.java.view.SkillView;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        SkillView view = new SkillView();
//        view.create();
//        view.create();
//        view.read();
//        view.update();
//        view.read();
//        view.delete();
//        view.read();

        DeveloperView dv = new DeveloperView();

        dv.create();
        dv.create();
        dv.read();
        dv.update();
        dv.read();
        dv.delete();
        dv.read();
    }
}
