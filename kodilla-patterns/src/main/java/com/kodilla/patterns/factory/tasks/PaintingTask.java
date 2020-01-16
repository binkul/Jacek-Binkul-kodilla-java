package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.tasks.repo.DataBaseStore;

public class PaintingTask implements Task {
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean taskDone;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        taskDone = true;
        DataBaseStore.getInstance().store(this);
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
        return "PaintingTask{" +
                "task='" + taskName + '\'' +
                ", color='" + color + '\'' +
                ", whatToPaint='" + whatToPaint + '\'' +
                '}';
    }
}
