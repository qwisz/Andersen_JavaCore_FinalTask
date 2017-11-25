package com.andersen.java.view;

import com.andersen.java.controller.SkillController;
import com.andersen.java.model.Skill;

import java.io.IOException;
import java.util.Scanner;

public class SkillView {

    private SkillController controller = new SkillController();
    private Scanner sc = new Scanner(System.in);

    public void create() throws IOException {

        System.out.println("Enter the name of the skill");
        controller.create(sc.nextLine());
        System.out.println("Skill is created");
    }

    public void read() throws IOException {

        System.out.println("Enter the id of the skill");
        String skill = controller.read(sc.nextLine());

        if (skill == null)
            System.out.println("Skill with such id doesn't exist");
        else
            System.out.println(skill);
    }

    public void update() throws IOException {

        System.out.println("Enter id of the skill");
        String id = sc.nextLine();
        System.out.println("Enter name of the skill");
        String name = sc.nextLine();

        if (controller.update(id, name))
            System.out.println("Skill is updated");
        else
            System.out.println("Skill isn't updated");
    }

    public void delete() throws IOException {

        System.out.println("Enter id");
        String id = sc.nextLine();

        controller.delete(id);
        System.out.println("Skill is deleted");
    }
}
