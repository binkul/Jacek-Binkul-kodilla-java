package com.kodilla.patterns2.observer.homework;

import java.util.Objects;

public class Task {
    private String number;
    private String title;

    public Task(String number, String title) {
        this.number = number;
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Task{" +
                "number='" + number + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(number, task.number) &&
                Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, title);
    }
}
