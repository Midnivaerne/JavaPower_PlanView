package model;

import java.util.LinkedList;
import java.util.List;

public class Person {

    private String Name;
    private String Surname;
    
    private List<Project> projectList;

    public Person(String Name, String Surname){
    	this.Name = Name;
    	this.Surname = Surname;
    	projectList = new LinkedList<>();
    }
    
    public Person(){
    	this.Name = new String();
    	this.Surname = new String();
    	projectList = new LinkedList<>();
    }
    
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
    
    public void addProjectListToPersonList(List<Project> taskList){
    	this.projectList.add((Project) taskList);
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
