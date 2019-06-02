package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Person {

    private String name;
    private String surname;
    
    private List<Project> projectList;

    public Person(String Name, String Surname){
    	this.name = Name;
    	this.surname = Surname;
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

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

// nie dzia³a do poprawy !!!    
//    public void addProjectListToPersonList(List<Project> taskList){
//    	this.projectList.add((Project) taskList);
//    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
