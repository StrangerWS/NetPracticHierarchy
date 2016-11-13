package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl;

import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Department;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Project;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.api.Human;

import java.util.TreeSet;

/**
 * Created by User on 13.11.2016.
 */
public class Employee extends Human {

    Department department;
    TreeSet<Project> projects;

    public Department getDepartment() {
        return department;
    }

    public TreeSet<Project> getProjects() {
        return projects;
    }

    public Employee(String name, Department department, TreeSet<Project> projects) {
        this.setName(name);
        this.department = department;
        this.projects = projects;
    }
}
