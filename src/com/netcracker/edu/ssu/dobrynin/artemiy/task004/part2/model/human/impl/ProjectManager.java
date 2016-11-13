package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl;

import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Department;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Project;

import java.util.TreeSet;

/**
 * Created by User on 13.11.2016.
 */
public class ProjectManager extends Employee {

    Project project;

    public ProjectManager(String name, Department department, TreeSet<Project> projects) {
        super(name, department, projects);
    }

    public ProjectManager(String name, Department department, TreeSet<Project> projects, Project project) {
        super(name, department, projects);
        this.project = project;
    }
}
