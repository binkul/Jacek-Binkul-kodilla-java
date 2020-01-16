package com.kodilla.patterns.prototype.library;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Before
    public void printBefore() {
        System.out.println("Test start.");
    }

    @After
    public void printAfter() {
        System.out.println("Test finished.");
    }

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Nicolaus Copernicus University Library");
        Book book = new Book("The Lords of the Rings", "J. R. R. Tolkien", LocalDate.parse("1954-05-04"));
        library.addBook(book);
        library.addBook(new Book("The Little Prince", "Antoine de Saint-Exupery", LocalDate.parse("1943-03-21")));
        library.addBook(new Book("Alice's Adventures in Wonderland", "Lewis Carroll", LocalDate.parse("1865-12-04")));
        library.addBook(new Book("The Da Vinci Code", "Dan Brown", LocalDate.parse("2003-08-12")));
        library.addBook(new Book("Lolita", "Vladimir Nabokov", LocalDate.parse("1955-11-01")));
        library.addBook(new Book("The Godfather", "Mario Puzo", LocalDate.parse("1969-02-27")));

        // Shallow copy
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Warsaw University library");
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }

        //Deep copy
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Wroclaw University of Science and Technology library");
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }

        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

        //When
        int countBeforeRemove = library.getBooks().size();
        library.getBooks().remove(book);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

        Assert.assertEquals(6, countBeforeRemove);
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, clonedLibrary.getBooks().size());
        Assert.assertEquals(6, deepClonedLibrary.getBooks().size());
        Assert.assertFalse(library.getBooks().contains(book));
        Assert.assertFalse(clonedLibrary.getBooks().contains(book));
        Assert.assertTrue(deepClonedLibrary.getBooks().contains(book));
    }

    @Test
    public void testDeepCopy() {
        //Given
        Library library = new Library("Nicolaus Copernicus University Library");
        Book book = new Book("The Lords of the Rings", "J. R. R. Tolkien", LocalDate.parse("1954-05-04"));
        library.addBook(book);

        // Shallow copy
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }

        //Deep copy
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }

        //When
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        book.setAuthor("New Author");

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals("New Author", library.getFirstBookAuthor());
        Assert.assertEquals("New Author", clonedLibrary.getFirstBookAuthor());
        Assert.assertEquals("J. R. R. Tolkien", deepClonedLibrary.getFirstBookAuthor());
    }
}
