package model;

public class Task {

    private String taskName;
    private int hoursCount;

    public Task(String taskName, int hoursCount){
    	this.taskName = taskName;
    	this.hoursCount = hoursCount;
    }
    
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getHoursCount() {
        return hoursCount;
    }

    public void setHoursCount(int hoursCount) {
        this.hoursCount = hoursCount;
    }
}
