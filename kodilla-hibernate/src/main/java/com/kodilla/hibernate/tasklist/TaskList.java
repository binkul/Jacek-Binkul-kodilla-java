package com.kodilla.hibernate.tasklist;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "tasklists")
public class TaskList {
    private int id;
    private String ListName;
    private String Description;

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

    @NotNull
    public String getListName() {
        return ListName;
    }

    public String getDescription() {
        return Description;
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
}
