package model;

import java.util.ArrayList;
import java.util.List;

public class Person {

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    private List<Project> projectList;

    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        projectList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public void setName(String name) {
        name = name;
    }

    public void setSurname(String surname) {
        surname = surname;
    }

}
