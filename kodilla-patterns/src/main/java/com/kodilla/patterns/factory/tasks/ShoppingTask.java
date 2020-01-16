package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.tasks.repo.DataBaseStore;

public class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean taskDone;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
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
        return "ShoppingTask{" +
                "task='" + taskName + '\'' +
                ", whatToBuy='" + whatToBuy + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
