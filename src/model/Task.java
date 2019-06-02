package model;

import java.util.Date;

public class Task {

    private String taskName;
    private double hoursCount;
    private Date date;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public double getHoursCount() {
        return hoursCount;
    }

    public void setHoursCount(double hoursCount) {
        this.hoursCount = hoursCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Task(Date date, String taskName, double hoursCount) {
        this.date = date;
        this.taskName = taskName;
        this.hoursCount = hoursCount;
    }
}
