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

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = shallowCopy();
        clonedLibrary.books = new HashSet<>();

        books.forEach(i -> clonedLibrary.getBooks().add(i));
        return clonedLibrary;
    }

    @Override
    public String toString() {
        String s = "Library '" + name + "':\n";
        for(Book book : books) {
            s = s + book.toString() + "\n";
        }
        return s;
    }
}
