package com.kodilla.patterns.prototype.clone;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardCloneTestSuite {
    @Test
    public void testToString() {
        //given
        //creating the TasksList for todos
        TasksList listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));

        //creating the TaskList for tasks in progress
        TasksList listInProgress = new TasksList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number " + n)));

        //creating the TaskList for done tasks
        TasksList listDone = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number " + n)));

        //creating the board and assigning the lists
        BoardClone board = new BoardClone("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        //Shallow clone of board
        BoardClone clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(board);
        System.out.println(clonedBoard);

        //making a deep copy of object board
        BoardClone deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        board.getLists().remove(listToDo);

        //Then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, clonedBoard.getLists().size());
        Assert.assertEquals(3, deepClonedBoard.getLists().size());
        Assert.assertEquals(clonedBoard.getLists(), board.getLists());
        Assert.assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}
