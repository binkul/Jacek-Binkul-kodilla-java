package com.kodilla.patterns2.adapter.company.bookclasifier;

import com.kodilla.patterns2.adapter.company.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.company.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        return medianPublicationYear(getBookMap(bookSet));
    }

    public  int publicationYearAverage(Set<Book> bookSet) {
        return averagePublicationYear(getBookMap(bookSet));
    }

    private Map<BookSignature, com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.Book> getBookMap(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.Book> books = new HashMap<>();
        for (Book book : bookSet) {
            books.put(new BookSignature(book.getSignature()),
                    new com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.Book(
                            book.getAuthor(),
                            book.getTitle(),
                            book.getPublicationYear()));
        }
        return books;
    }
}
