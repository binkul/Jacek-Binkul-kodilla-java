package com.kodilla.spring.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibrarySetterTestSuit {
    @Test
    public void testLoadFromDb() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        LibraryThree libraryThree = (LibraryThree) context.getBean("libraryThree");
        //When
        libraryThree.loadFromDb();
        //Then
        //do nothing
    }

    @Test
    public void testSaveToDb() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        LibraryThree libraryThree = (LibraryThree) context.getBean("libraryThree");
        //When
        libraryThree.saveToDb();
        //Then
        //do nothing
    }
}
