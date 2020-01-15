package com.kodilla.patterns.prototype.clone;

import java.util.HashSet;
import java.util.Set;

public class BoardClone extends Prototype {
    private String name;
    private Set<TasksList> lists = new HashSet<>();

    public BoardClone(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "BoardClone [" + name + "]\n";
        for(TasksList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    public BoardClone shallowCopy() throws CloneNotSupportedException {
        return (BoardClone) super.clone();
    }

    public BoardClone deepCopy() throws CloneNotSupportedException {
        BoardClone clonedBoard = (BoardClone) super.clone();
        clonedBoard.lists = new HashSet<>();
        for(TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            for(Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }

}
