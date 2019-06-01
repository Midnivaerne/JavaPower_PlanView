package model;

import java.util.LinkedList;
import java.util.List;

public class Project {

	private String projectName;
    private List<Task> taskList;
    
    public Project(String projectName){
    	this.projectName = projectName;
    	taskList = new LinkedList<>();
    }
    
    public Project(){
    	this.projectName = new String();
    	taskList = new LinkedList<>();
    }
    
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setProjectName(String projectName){
    	this.projectName = projectName;
    }
    
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
    
    public void addTaskToProjectList(Task task){
    	this.taskList.add(task);
    }

}
