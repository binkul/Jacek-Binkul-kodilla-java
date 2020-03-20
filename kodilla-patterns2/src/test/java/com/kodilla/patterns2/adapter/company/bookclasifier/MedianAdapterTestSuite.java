package com.kodilla.patterns2.adapter.company.bookclasifier;

import com.kodilla.patterns2.adapter.company.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        // Given
        Book bookA = new Book("Bolesław Prus", "Lalka", 2008, "A287568");
        Book bookB = new Book("Henryk Sienkiewicz", "Potop", 1978, "B87658");
        Book bookC = new Book("Adam Mickiewicz", "Pan Tadeusz", 1967, "A783073");
        Book bookD = new Book("Kornel Makuszyński", "Awantura o Basię", 2010, "B0772228");
        Book bookE = new Book("Adam Bahdaj", "Wakacje z duchami", 1961, "A06736309");
        Set<Book> books = new HashSet<>(Arrays.asList(bookA, bookB, bookC, bookD, bookE));
        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int median = medianAdapter.publicationYearMedian(books);

        // Then
        assertEquals(1978, median);
    }

    @Test
    public void publicationYearMedianEvenTest() {
        // Given
        Book bookA = new Book("Bolesław Prus", "Lalka", 2008, "A287568");
        Book bookB = new Book("Adam Mickiewicz", "Pan Tadeusz", 1967, "A783073");
        Book bookC = new Book("Adam Bahdaj", "Wakacje z duchami", 1961, "A06736309");
        Book bookD = new Book("Adam Bahdaj", "Wakacje z duchami", 1961, "A06736309");
        Set<Book> books = new HashSet<>(Arrays.asList(bookA, bookB, bookC, bookD));
        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int median = medianAdapter.publicationYearMedian(books);

        // Then
        assertEquals(1967, median);
    }

    @Test
    public void publicationYearAverageTest() {
        // Given
        Book bookA = new Book("Bolesław Prus", "Lalka", 2008, "A287568");
        Book bookB = new Book("Henryk Sienkiewicz", "Potop", 1978, "B87658");
        Book bookC = new Book("Adam Mickiewicz", "Pan Tadeusz", 1967, "A783073");
        Book bookD = new Book("Kornel Makuszyński", "Awantura o Basię", 2010, "B0772228");
        Book bookE = new Book("Adam Bahdaj", "Wakacje z duchami", 1961, "A06736309");
        Set<Book> books = new HashSet<>(Arrays.asList(bookA, bookB, bookC, bookD, bookE));
        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int median = medianAdapter.publicationYearAverage(books);

        // Then
        assertEquals(1984, median);
    }
}