package com.kodilla.patterns.factory.tasks.repo;

import com.kodilla.patterns.factory.tasks.Task;

public class FileStore implements Storable {
    private static FileStore fileStoreInstance = null;

    private FileStore() {}

    public static FileStore getInstance() {
        if (fileStoreInstance == null) {
            synchronized (FileStore.class) {
                if (fileStoreInstance == null) {
                    fileStoreInstance = new FileStore();
                }
            }
        }
        return fileStoreInstance;
    }

    @Override
    public void store(Task task) {
        System.out.format("Task '%s' saved to file.\n", task.getTaskName());
    }
}
