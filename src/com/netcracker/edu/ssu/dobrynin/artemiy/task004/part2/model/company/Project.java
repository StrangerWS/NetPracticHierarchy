package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company;

import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.Customer;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.Employee;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.ProjectManager;

import java.util.TreeSet;

/**
 * Created by User on 13.11.2016.
 */
public class Project {

    Customer customer;
    ProjectManager manager;
    TreeSet<Employee> employees;

    public Project(Customer customer) {

        this.customer = customer;
    }

    public Project(Customer customer, ProjectManager manager) {
        this.customer = customer;
        this.manager = manager;
    }

    public Project(Customer customer, ProjectManager manager, TreeSet<Employee> employees) {

        this.customer = customer;
        this.manager = manager;
        this.employees = employees;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ProjectManager getManager() {
        return manager;
    }

    public TreeSet<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (customer != null ? !customer.equals(project.customer) : project.customer != null) return false;
        if (manager != null ? !manager.equals(project.manager) : project.manager != null) return false;
        return employees != null ? employees.equals(project.employees) : project.employees == null;

    }

    @Override
    public int hashCode() {
        int result = customer != null ? customer.hashCode() : 0;
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }
}
