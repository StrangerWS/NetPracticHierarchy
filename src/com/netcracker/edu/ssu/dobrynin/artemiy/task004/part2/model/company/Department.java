package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company;

import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.Employee;

import java.util.TreeSet;

/**
 * Created by User on 13.11.2016.
 */
public class Department {

    private String name;
    private TreeSet<Employee> employees;

    public TreeSet<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
