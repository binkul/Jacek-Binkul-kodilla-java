package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = (Board) context.getBean("getBoard");

        board.getToDoList().addTask("Task one is to do.");
        board.getInProgressList().addTask("Task two is in progress.");
        board.getDoneList().addTask("Task three is done.");

        //When
        String taskOne = board.getToDoList().getTask().get(0);
        String taskTwo = board.getInProgressList().getTask().get(0);
        String taskThree = board.getDoneList().getTask().get(0);

        //Then
        Assert.assertEquals("Task one is to do.", taskOne);
        Assert.assertEquals("Task two is in progress.", taskTwo);
        Assert.assertEquals("Task three is done.", taskThree);
    }

    @Test
    public void testTaskAddCount() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        board.getToDoList().addTask("Task1 is to do.");
        board.getToDoList().addTask("Task2 is to do.");
        board.getToDoList().addTask("Task3 is to do.");

        //When
        int taskOne = board.getToDoList().getTask().size();
        int taskTwo = board.getInProgressList().getTask().size();
        int taskThree = board.getDoneList().getTask().size();

        //Then
        Assert.assertEquals(3, taskOne);
        Assert.assertEquals(0, taskTwo);
        Assert.assertEquals(0, taskThree);
    }

    @Test
    public void testTaskRemove() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        board.getInProgressList().addTask("Task1 is in progress.");
        board.getInProgressList().addTask("Task2 is in progress.");
        board.getInProgressList().addTask("Task3 is in progress.");

        //When
        board.getInProgressList().removeTask("Task2 is in progress.");
        int taskOne = board.getToDoList().getTask().size();
        int taskTwo = board.getInProgressList().getTask().size();
        int taskThree = board.getDoneList().getTask().size();

        //Then
        Assert.assertEquals(0, taskOne);
        Assert.assertEquals(2, taskTwo);
        Assert.assertEquals(0, taskThree);
    }

    @Test
    public void testBeansExists() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = (Board) context.getBean("getBoard");

        //When
        boolean taskOneExist = context.containsBean("taskList1");
        boolean taskTwoExist = context.containsBean("taskList2");
        boolean taskThreeExist = context.containsBean("taskList3");

        //Then
        Assert.assertTrue(taskOneExist);
        Assert.assertTrue(taskTwoExist);
        Assert.assertTrue(taskThreeExist);
    }
}
