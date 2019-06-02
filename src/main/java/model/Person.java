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

    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        projectList = new ArrayList<>();
    }

    public Person(){
    	this.name = new String();
    	this.surname = new String();
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


