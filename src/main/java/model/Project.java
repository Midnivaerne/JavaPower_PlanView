package model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private List<Task> taskList;


    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    String name;

    public Project(String name) {
        this.name = name;
        taskList = new ArrayList<>();
    }

}
