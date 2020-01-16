package com.kodilla.patterns.factory.tasks.repo;

import com.kodilla.patterns.factory.tasks.Task;

public interface Storable {
    void store(Task task);
}
