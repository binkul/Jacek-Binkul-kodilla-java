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
    private String ListName;
    private String Description;
    List<Task> tasks = new ArrayList<>();

    public TaskList() {}

    public TaskList(String listName, String description) {
        ListName = listName;
        Description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @Column(name = "LISTNAME")
    @NotNull
    public String getListName() {
        return ListName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return Description;
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
        ListName = listName;
    }

    private void setDescription(String description) {
        Description = description;
    }

    private void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
