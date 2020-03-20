package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Module implements Observable {
    private final List<Observer> observers;
    private final Deque<Task> tasks;
    private String title;

    public Module(String title) {
        observers = new ArrayList<>();
        tasks = new ArrayDeque<>();
        this.title = title;
    }

    public void addTask(Task task) {
        tasks.offer(task);
        notifyObservers(task);
    }

    public Deque<Task> getTasks() {
        return tasks;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        tasks.poll();
    }

    @Override
    public void notifyObservers(Task task) {
        for (Observer observer : observers) {
            observer.update(this, task);
        }
    }
}
