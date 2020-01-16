package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.clone.Prototype;

import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getFirstBookAuthor() {
        return books.iterator().hasNext() ? books.iterator().next().getAuthor() : null;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = shallowCopy();
        clonedLibrary.books = new HashSet<>();

        books.forEach(i -> clonedLibrary.addBook(new Book(i.getTitle(), i.getAuthor(), i.getPublicationDate())));
        return clonedLibrary;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Library '" + name + "':\n");
        for(Book book : books) {
            s.append(book.toString()).append("\n");
        }
        return s.toString();
    }
}
