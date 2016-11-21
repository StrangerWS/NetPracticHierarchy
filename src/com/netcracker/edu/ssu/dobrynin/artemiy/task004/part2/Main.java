package com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2;

import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.facade.Facade;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Company;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Department;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.company.Project;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.Customer;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.Employee;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.model.human.impl.ProjectManager;
import com.netcracker.edu.ssu.dobrynin.artemiy.task004.part2.view.View;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by User on 04.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        Department programmers = new Department("Programmers");
        Department designers = new Department("Designers");
        Department testers = new Department("Testers");

        Employee employee1 = new Employee("Petrov", programmers);
        Employee employee2 = new Employee("Smirnov", designers);
        Employee employee3 = new Employee("Ivanov", testers);
        Employee employee4 = new Employee("Vasilyev", testers);
        Employee employee5 = new Employee("TEMP1", programmers);
        Employee employee6 = new Employee("TEMP2", programmers);
        Employee employee7 = new Employee("TEMP3", designers);
        Employee employee8 = new Employee("TEMP4", designers);
        Employee employee9 = new Employee("TEMP5", programmers);
        Employee employee10 = new Employee("TEMP6", designers);
        Employee employee11 = new Employee("TEMP7", designers);

        ProjectManager lead1 = new ProjectManager("Vasechkin", programmers);
        ProjectManager lead2 = new ProjectManager("Demianov", programmers);
        ProjectManager lead3 = new ProjectManager("Sokolov", programmers);

        Customer customer1 = new Customer("Vasya");
        Customer customer2 = new Customer("Petya");
        Customer customer3 = new Customer("Senya");

        Project project1 = new Project("Tizhprogrammist", customer3, lead1, new TreeSet<>(Arrays.asList(new Employee[]{employee1, employee2, employee9, employee10})));
        Project project2 = new Project("CasualGame", customer2, lead2, new TreeSet<>(Arrays.asList(new Employee[]{employee1, employee4, employee7, employee9})));
        Project project3 = new Project("HardCode", customer2, lead3, new TreeSet<>(Arrays.asList(new Employee[]{employee6, employee5, employee3, employee8})));
        Project project4 = new Project("HardGame", customer1, lead3, new TreeSet<>(Arrays.asList(new Employee[]{employee10, employee6, employee3, employee8, employee5})));
        Project project5 = new Project("VisualNovel", customer1, lead1, new TreeSet<>(Arrays.asList(new Employee[]{employee9, employee2, employee7, employee3})));
        Project project6 = new Project("NO NAME", customer1, lead3, new TreeSet<>(Arrays.asList(new Employee[]{employee1, employee7, employee10, employee8, employee5})));

        Company SSU = new Company(new TreeSet<>(Arrays.asList(new Department[]{programmers, designers, testers})),
                new TreeSet<>(Arrays.asList(new Project[]{project1, project2, project3, project4, project5, project6})));

        View.printTreeSet(Facade.getColleaguesForEmployee(employee1));
        View.printTreeSet(Facade.getEmployeeProjects(employee5));
        View.printTreeSet(Facade.getProjectForCustomer(customer1));
        View.printTreeSet(Facade.getManagersForSlave(employee8));
        View.printTreeSet(Facade.getSlavesForManager(lead1));
        View.printTreeSet(Facade.getUnassignedFromCompany(SSU));
        View.printTreeSet(Facade.getUnassignedFromDepartment(designers));
        View.printTreeSet(Facade.getProjectWorkers(project4));
        View.printTreeSet(Facade.getEmployeesForCustomersProjects(customer1));
    }
}
