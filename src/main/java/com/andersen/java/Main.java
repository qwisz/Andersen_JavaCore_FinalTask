package com.andersen.java;

import com.andersen.java.service.SkillService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SkillService ss = new SkillService();
        ss.create("Python");
    }
}
