package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public final Task makeTask(TaskType type) {
        switch (type) {
            case DRIVING:
                return new DrivingTask("Driving around the town", "Toruń", "Car");
            case SHOPPING:
                return new ShoppingTask("Shopping in Center", "Pants", 2);
            case PAINTING:
                return new PaintingTask("Paint at customer's home","Purple", "Room");
            default:
                throw new IllegalArgumentException("There is no such task '" + type.name() + "'");
        }
    }
}
