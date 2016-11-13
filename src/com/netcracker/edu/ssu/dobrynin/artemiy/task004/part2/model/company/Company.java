package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company;

import java.util.TreeSet;

/**
 * Created by User on 13.11.2016.
 */
public class Company {

    private TreeSet<Department> departments;
    private TreeSet<Project> projects;

    public Company(TreeSet<Department> departments, TreeSet<Project> projects) {
        this.departments = departments;
        this.projects = projects;
    }

    public TreeSet<Department> getDepartments() {
        return departments;
    }

    public TreeSet<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}
