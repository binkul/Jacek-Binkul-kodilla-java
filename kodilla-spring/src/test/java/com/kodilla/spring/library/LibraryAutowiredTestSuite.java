package com.kodilla.spring.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryAutowiredTestSuite {
    @Test
    public void testLoadFromDb() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        LibraryTwo libraryTwo = (LibraryTwo) context.getBean("libraryTwo");
        //When
        libraryTwo.loadFromDb();
        //Then
        //do nothing
    }

    @Test
    public void testSaveToDb() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        LibraryTwo libraryTwo = (LibraryTwo) context.getBean("libraryTwo");
        //When
        libraryTwo.saveToDb();
        //Then
        //do nothing
    }
}
