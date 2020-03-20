package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Module module, Task task) {
        System.out.println(name + " receive new task to check in module: " + module.getTitle() + "\n" +
                "Task: " + task.getNumber() + "/" + task.getTitle() +
                " (Total: " + module.getTasks().size() + " tasks.)" + "\n");
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
