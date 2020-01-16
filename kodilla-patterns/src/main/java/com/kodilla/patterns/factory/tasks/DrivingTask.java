package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.tasks.repo.DataBaseStore;
import com.kodilla.patterns.factory.tasks.repo.FileStore;

public class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean taskDone;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        taskDone = true;
        FileStore.getInstance().store(this);
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskDone;
    }

    @Override
    public String toString() {
        return "DrivingTask{" +
                "task='" + taskName + '\'' +
                ", where='" + where + '\'' +
                ", using='" + using + '\'' +
                '}';
    }
}
