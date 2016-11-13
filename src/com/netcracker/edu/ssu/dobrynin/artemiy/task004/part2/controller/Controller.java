package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.controller;

import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Company;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Department;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Project;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.Customer;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.Employee;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.ProjectManager;

import java.util.TreeSet;

/**
 * Created by User on 13.11.2016.
 */
public class Controller {

    public TreeSet<Employee> getProjectWorkers(Project project) {
        return project.getEmployees();
    }

    public TreeSet<Project> getEmployeeProjects(Employee employee) {
        return employee.getProjects();
    }

    public TreeSet<Employee> getUnassignedFromDepartment(Department department) {
        TreeSet<Employee> unassignedDepartment = new TreeSet<>();

        for (Employee employee : department.getEmployees()) {
            if (employee.getProjects().size() == 0) {
                unassignedDepartment.add(employee);
            }
        }

        return unassignedDepartment;
    }

    public TreeSet<Employee> getUnassignedFromCompany(Company company) {
        TreeSet<Employee> unassignedCompany = new TreeSet<>();

        for (Department department : company.getDepartments()) {
            unassignedCompany.addAll(getUnassignedFromDepartment(department));
        }

        return unassignedCompany;
    }

    public TreeSet<Employee> getSlavesForManager(ProjectManager manager) {
        TreeSet<Employee> slaves = new TreeSet<>();

        for (Project project : manager.getProjects()) {
            slaves.addAll(getProjectWorkers(project));
        }

        return slaves;
    }

    public TreeSet<ProjectManager> getManagersForSlave(Employee slave) {
        TreeSet<ProjectManager> managers = new TreeSet<>();

        for (Project project : slave.getProjects()) {
            managers.add(project.getManager());
        }

        return managers;
    }

    public TreeSet<Employee> getColleaguesForEmployee(Employee employee) {
        TreeSet<Employee> employees = new TreeSet<>();

        for (Project project : employee.getProjects()) {
            employees.addAll(getProjectWorkers(project));
        }

        return employees;
    }

    public TreeSet<Project> getProjectForCustomer(Customer customer) {
        return customer.getProjects();
    }

    public TreeSet<Employee> getEmployeesForCustomersProjects(Customer customer) {
        TreeSet<Employee> employees = new TreeSet<>();

        for (Project project : customer.getProjects()) {
            employees.addAll(getProjectWorkers(project));
        }

        return employees;
    }
}
