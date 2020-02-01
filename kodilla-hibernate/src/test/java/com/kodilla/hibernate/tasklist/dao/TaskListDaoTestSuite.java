package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "What is to do in the next week";
    private static final String LIST_NAME_ONE = "To do.";
    private static final String LIST_NAME_TWO = "Not to do.";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList1 = new TaskList(LIST_NAME_ONE, DESCRIPTION);
        TaskList taskList2 = new TaskList(LIST_NAME_TWO, DESCRIPTION);

        //When
        taskListDao.save(taskList1);
        taskListDao.save(taskList2);

        //Then
        String name = taskList1.getListName();
        List<TaskList> readName = taskListDao.findByListName(name);
        Assert.assertNotNull(readName);
        Assert.assertEquals(1, readName.size());
        Assert.assertEquals(LIST_NAME_ONE, readName.get(0).getListName());

        //Cleanup
        taskListDao.deleteAll();
    }
}
