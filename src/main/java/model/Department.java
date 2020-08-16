package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A Department within the Company
 *
 * @author Sebastian Rodriguez, 2020. email: sebastian.rodriguez@rmit.edu.au
 */
public class Department {
    private String name;
    private List<Project> projects = new ArrayList<Project>();
    private List<Employee> employees = new ArrayList<Employee>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public boolean canHostProject(int duration){
        return false;
    }
}
