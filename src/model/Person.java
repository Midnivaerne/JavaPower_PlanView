package model;

import java.util.List;

public class Person {

    private String Name;

    private String Surname;
    private List<Project> projectList;

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return Name + " " + Surname;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
