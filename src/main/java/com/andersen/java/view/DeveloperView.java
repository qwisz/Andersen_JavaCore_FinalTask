package com.andersen.java.view;

import com.andersen.java.controller.DeveloperController;
import com.andersen.java.model.Skill;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeveloperView {

    private DeveloperController controller = new DeveloperController();
    private Scanner sc = new Scanner(System.in);

    public void create() throws IOException {

        String firstName;
        String lastName;
        String speciality;
        Set<Long> skillsId;
        BigDecimal salary;

        System.out.println("Enter the name:");
        firstName = sc.nextLine();
        System.out.println("Enter the last name:");
        lastName = sc.nextLine();
        System.out.println("Enter speciality:");
        speciality = sc.nextLine();
        skillsId = getSkillsId();
        salary = getSalary();

        if (controller.create(firstName, lastName, speciality, skillsId, salary))
            System.out.println("Developer is created");
        else
            System.out.println("Developer is not created");
    }

    public void read() throws IOException {

        Long id = null;
        boolean check = false;

        while (!check) {
            System.out.println("Enter the skill of the developer");

            if (sc.hasNextLong()) {
                id = sc.nextLong();
                check = true;
            } else {
                System.out.println("Wrong answer,repeat please");
                sc.next();
            }
        }

        System.out.println(controller.read(id));
    }

    public void update() throws IOException {
        Long id = getId();
        String firstName;
        String lastName;
        String speciality;
        Set<Long> skillsId;
        BigDecimal salary;

        System.out.println("Enter the name:");
        firstName = sc.nextLine();
        System.out.println("Enter the last name:");
        lastName = sc.nextLine();
        System.out.println("Enter speciality:");
        speciality = sc.nextLine();

        skillsId = getSkillsId();
        salary = getSalary();

        if (controller.update(id, firstName, lastName, speciality, skillsId, salary)) {
            System.out.println("Developer is updated");
        } else {
            System.out.println("Developer is not updated");
        }
    }

    public void delete() throws IOException {
        Long id = getId();

        controller.delete(id);
    }

    private Long getId() throws IOException {
        boolean check = false;
        Long id = null;

        while (!check) {
            System.out.println("Enter the skill of the developer");

            if (sc.hasNextLong()) {
                id = sc.nextLong();
                if (controller.isExist(id))
                    check = true;
                else {
                    System.out.println("Developer with such id doesn't exist");
                }
            } else {
                System.out.println("Wrong answer,repeat please");
                sc.next();
            }
        }

        return id;
    }

    private Set<Long> getSkillsId() {
        Set<Long> skillsId = new HashSet<>();
        boolean check = false;
        int numOfSkills = -1;

        while(!check) {
            System.out.println("Enter the number of skills:");
            if (sc.hasNextInt()) {
                numOfSkills = sc.nextInt();
                check = true;
            } else {
                System.out.println("Wrong answer, please repeat");
                sc.next();
                check = false;
            }
        }
        int i = 0;
        while(i != numOfSkills) {
            System.out.println("Enter the skill's id");
            if (sc.hasNextLong()) {
                skillsId.add(sc.nextLong());
                i += 1;
            } else {
                System.out.println("Wrong answer, please repeat");
                sc.next();
            }
        }

        return skillsId;
    }

    private BigDecimal getSalary() {
        boolean check = false;
        BigDecimal salary = null;

        while (!check) {
            System.out.println("Enter the salary:");
            if (sc.hasNextBigDecimal()) {
                salary = sc.nextBigDecimal();
                check = true;
            } else {
                System.out.println("Wrong answer, please repeat");
                sc.next();
                check = false;
            }
        }
        return salary;
    }
}
