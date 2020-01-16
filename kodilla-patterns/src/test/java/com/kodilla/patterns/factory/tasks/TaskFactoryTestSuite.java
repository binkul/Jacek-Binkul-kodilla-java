package com.kodilla.patterns.factory.tasks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Before
    public void printBefore() {
        System.out.println("\nTest start.");
    }

    @After
    public void printAfter() {
        System.out.println("Test finished.");
    }

    @Test
    public void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.makeTask(TaskType.SHOPPING);
        boolean beforeExecuted = shopping.isTaskExecuted();
        shopping.executeTask();
        System.out.println("Shopping test ...");
        System.out.println(shopping);

        //Then
        Assert.assertEquals("Shopping in Center", shopping.getTaskName());
        Assert.assertFalse(beforeExecuted);
        Assert.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task driving = factory.makeTask(TaskType.DRIVING);
        boolean beforeExecuted = driving.isTaskExecuted();
        driving.executeTask();
        System.out.println("Driving test ...");
        System.out.println(driving);

        //Then
        Assert.assertEquals("Driving around the town", driving.getTaskName());
        Assert.assertFalse(beforeExecuted);
        Assert.assertTrue(driving.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task painting = factory.makeTask(TaskType.PAINTING);
        boolean beforeExecuted = painting.isTaskExecuted();
        painting.executeTask();
        System.out.println("Painting test ...");
        System.out.println(painting);

        //Then
        Assert.assertEquals("Paint at customer's home", painting.getTaskName());
        Assert.assertFalse(beforeExecuted);
        Assert.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testFactoryNotOnTheList() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        //Then
        try {
            Task working = factory.makeTask(TaskType.WORKING);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
