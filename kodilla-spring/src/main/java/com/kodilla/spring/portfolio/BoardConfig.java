package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    @Autowired
    @Qualifier("taskList1")
    TaskList taskListOne;

    @Autowired
    @Qualifier("taskList2")
    TaskList taskListTwo;

    @Autowired
    @Qualifier("taskList3")
    TaskList taskListThree;

    @Bean
    public Board getBoard() {
        return new Board(taskListOne, taskListTwo, taskListThree);
    }

    @Bean(name = "taskList1")
    @Scope("prototype")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "taskList2")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "taskList3")
    @Scope("prototype")
    public TaskList getDoneList() {
        return new TaskList();
    }
}
