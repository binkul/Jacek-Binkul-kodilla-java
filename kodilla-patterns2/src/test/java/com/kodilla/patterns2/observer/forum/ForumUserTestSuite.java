package com.kodilla.patterns2.observer.forum;

import static org.junit.Assert.*;
import org.junit.Test;

public class ForumUserTestSuite {
    @Test
    public void testUpdate() {
        // Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic toolsForumTopic = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivonneEscobar = new ForumUser("Ivonne Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");
        javaHelpForum.registerObserver(johnSmith);
        toolsForumTopic.registerObserver(ivonneEscobar);
        javaHelpForum.registerObserver(jessiePinkman);
        toolsForumTopic.registerObserver(jessiePinkman);

        // When
        javaHelpForum.addPost("Hi everyone! Could You help me with for loop?");
        javaHelpForum.addPost("Better try to use while loop in this case");
        toolsForumTopic.addPost("Help pls, my MySql db does'n want to work :(");
        javaHelpForum.addPost("Why while? Is it better?");
        toolsForumTopic.addPost("When I try to log in I got 'bad credentials' message");

        // Then
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(2, ivonneEscobar.getUpdateCount());
        assertEquals(5, jessiePinkman.getUpdateCount());
    }
}