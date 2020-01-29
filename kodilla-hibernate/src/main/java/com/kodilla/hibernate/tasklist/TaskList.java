package com.kodilla.hibernate.tasklist;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "TASKLIST")
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
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
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
