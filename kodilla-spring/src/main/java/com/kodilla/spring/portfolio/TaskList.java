package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskList {
    private final List<String> task;

    TaskList() {
        task = new ArrayList<>();
    }

    public void addTask(String task) {
        this.task.add(task);
    }

    public void removeTask(String task) {
        this.task.remove(task);
    }

    public List<String> getTask() {
        return task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof TaskList)) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(task, taskList.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task);
    }
}
