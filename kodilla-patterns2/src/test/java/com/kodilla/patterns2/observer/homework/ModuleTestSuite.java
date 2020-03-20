package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModuleTestSuite {

    @Test
    public void testUpdate() {
        // Given
        Task taskOne = new Task("1.1", "List stream");
        Task taskTwo = new Task("1.2", "Map stream");
        Task taskThree = new Task("2.1", "Spring introduction");
        Task taskFour = new Task("2.2", "Spring web");
        Task taskFive = new Task("3.1", "Rest Api");
        Task taskSix = new Task("3.2", "Rest Api part II");
        Mentor johnSmith = new Mentor("John Smith");
        Mentor arthurBean = new Mentor("Arthur Bean");

        Module streamModule = new Module("Stream through collection module");
        streamModule.registerObserver(johnSmith);
        Module springModule = new Module("Spring framework module");
        springModule.registerObserver(johnSmith);
        springModule.registerObserver(arthurBean);
        Module restApiModule = new Module("Rest Api module");
        restApiModule.registerObserver(johnSmith);
        restApiModule.registerObserver(arthurBean);

        // When
        streamModule.addTask(taskOne);
        streamModule.addTask(taskTwo);
        springModule.addTask(taskThree);
        springModule.addTask(taskFour);
        restApiModule.addTask(taskFive);
        restApiModule.addTask(taskSix);

        // Then
        assertEquals(6, johnSmith.getUpdateCount());
        assertEquals(4, arthurBean.getUpdateCount());
    }
}