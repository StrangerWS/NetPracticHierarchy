package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl;

import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Project;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.api.Human;

import java.util.TreeSet;

/**
 * Created by User on 13.11.2016.
 */
public class Customer extends Human {

    private TreeSet<Project> projects;

    public TreeSet<Project> getProjects() {
        return projects;
    }

    public Customer(String name) {
        this.setName(name);
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}
