package model;

import java.util.List;

public class Person {

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    private List<Project> projectList;
}
