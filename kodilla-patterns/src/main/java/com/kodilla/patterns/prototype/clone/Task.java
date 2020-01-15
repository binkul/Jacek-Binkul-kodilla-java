package com.kodilla.patterns.prototype.clone;

public class Task {
    final private String name;

    public Task(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "      Task [" + name + "]";
    }
}
