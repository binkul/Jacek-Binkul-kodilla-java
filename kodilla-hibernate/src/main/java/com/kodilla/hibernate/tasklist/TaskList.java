package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.Task;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKLIST")
public class TaskList {
    private int id;
    private String listName;
    private String description;
    List<Task> tasks = new ArrayList<>();

    public TaskList() {}

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @NotNull
    public String getListName() {
        return listName;
    }

    public String getDescription() {
        return description;
    }

    @OneToMany(targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Task> getTasks() {
        return tasks;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
