package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company;

import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.Employee;

import java.util.TreeSet;

/**
 * Created by User on 13.11.2016.
 */
public class Department implements Comparable<Department> {

    private String name;
    private TreeSet<Employee> employees;

    public TreeSet<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public Department(String name) {

        this.name = name;
    }

    public Department(String name, TreeSet<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
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

    @Override
    public int compareTo(Department o) {
        return name.compareTo(o.getName());
    }
}
