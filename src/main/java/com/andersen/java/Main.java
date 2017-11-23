package com.andersen.java;

import com.andersen.java.view.SkillView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        SkillService ss = new SkillService();
//        DeveloperService ds = new DeveloperService();
//        Set<String> skills = new HashSet<>();
//        skills.add("Java");
//        skills.add("Python");
//        BigDecimal salary = new BigDecimal(40000);
//        ds.create("Anton", "Barybin", "Enterprise", skills, salary);

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
