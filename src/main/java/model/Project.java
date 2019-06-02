package model;

import java.util.ArrayList;
import java.util.List;

public class Project {

	private String projectName;
    private List<Task> taskList;
    
    public Project(){
    	this.projectName = new String();
    	taskList = new ArrayList<Task>();
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setProjectName(String projectName){
    	this.projectName = projectName;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public void addTaskToProjectList(Task task){
    	this.taskList.add(task);
    }


    String name;

    public Project(String projectName){
        this.projectName = projectName;
        taskList = new ArrayList<Task>();
    }

}
