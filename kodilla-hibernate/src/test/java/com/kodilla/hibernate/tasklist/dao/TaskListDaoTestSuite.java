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
    private static final String LIST_NAME = "To do.";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        String name = taskList.getListName();
        List<TaskList> readName = taskListDao.findByListName(name);
        Assert.assertNotNull(readName);
        Assert.assertEquals(1, readName.size());
        Assert.assertEquals(LIST_NAME, readName.get(0).getListName());

        //Cleanup
        taskListDao.deleteById(id);
    }
}
