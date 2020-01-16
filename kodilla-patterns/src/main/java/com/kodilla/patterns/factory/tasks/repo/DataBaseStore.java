package com.kodilla.patterns.factory.tasks.repo;

import com.kodilla.patterns.factory.tasks.Task;

public class DataBaseStore implements Storable {
    private static DataBaseStore dataBaseStoreInstance = null;

    private DataBaseStore() {}

    public static DataBaseStore getInstance() {
        if (dataBaseStoreInstance == null) {
            synchronized (DataBaseStore.class) {
                if (dataBaseStoreInstance == null) {
                    dataBaseStoreInstance = new DataBaseStore();
                }
            }
        }
        return dataBaseStoreInstance;
    }

    @Override
    public void store(Task task) {
        System.out.format("Task '%s' was saved to local database.\n", task.getTaskName());
    }
}
