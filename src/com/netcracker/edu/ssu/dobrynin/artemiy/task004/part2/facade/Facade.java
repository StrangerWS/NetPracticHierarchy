package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.facade;

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
public class Facade {

    public static TreeSet<Employee> getProjectWorkers(Project project) {
        return project.getEmployees();
    }

    public static TreeSet<Project> getEmployeeProjects(Employee employee) {
        return employee.getProjects();
    }

    public static TreeSet<Employee> getUnassignedFromDepartment(Department department) {
        TreeSet<Employee> unassignedDepartment = new TreeSet<>();

        for (Employee employee : department.getEmployees()) {
            if (employee.getProjects().size() == 0) {
                unassignedDepartment.add(employee);
            }
        }

        return unassignedDepartment;
    }

    public static TreeSet<Employee> getUnassignedFromCompany(Company company) {
        TreeSet<Employee> unassignedCompany = new TreeSet<>();

        for (Department department : company.getDepartments()) {
            unassignedCompany.addAll(getUnassignedFromDepartment(department));
        }

        return unassignedCompany;
    }

    public static TreeSet<Employee> getSlavesForManager(ProjectManager manager) {
        TreeSet<Employee> slaves = new TreeSet<>();

        for (Project project : manager.getProjects()) {
            slaves.addAll(getProjectWorkers(project));
        }

        return slaves;
    }

    public static TreeSet<ProjectManager> getManagersForSlave(Employee slave) {
        TreeSet<ProjectManager> managers = new TreeSet<>();

        for (Project project : slave.getProjects()) {
            managers.add(project.getManager());
        }

        return managers;
    }

    public static TreeSet<Employee> getColleaguesForEmployee(Employee employee) {
        TreeSet<Employee> employees = new TreeSet<>();

        for (Project project : employee.getProjects()) {
            employees.addAll(getProjectWorkers(project));
        }

        return employees;
    }

    public static TreeSet<Project> getProjectForCustomer(Customer customer) {
        return customer.getProjects();
    }

    public static TreeSet<Employee> getEmployeesForCustomersProjects(Customer customer) {
        TreeSet<Employee> employees = new TreeSet<>();

        for (Project project : customer.getProjects()) {
            employees.addAll(getProjectWorkers(project));
        }

        return employees;
    }
}
