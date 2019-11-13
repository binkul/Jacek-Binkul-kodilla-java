package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.pearson.People;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(" ") + 2) + ".")
                .filter(s -> s.charAt(0) == 'M')
                .forEach(s -> System.out.println(s));

        System.out.println();

        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach((s) -> System.out.println(s));
        


        /*
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Jacek Binkul", text -> "### " + text + " ###");
        poemBeautifier.beautify("Lato było przedziwne tego roku", text -> text.replaceAll(" ", "_"));
        poemBeautifier.beautify("jacekbinkul", text -> text + "@gmail.com");
        poemBeautifier.beautify("Jacek binkul", text -> text.toUpperCase());
        poemBeautifier.beautify("Jacek     Binkul    pisze     programy", text -> text.replaceAll(" {2,}", " "));

        PoemDecorator poemDecorator = (text) -> {
            String result = "";
            for (int i = text.length() - 1; i >= 0; i--) {
                result += text.charAt(i);
            }
            return result;
        };
        System.out.println("Text from back: " + poemDecorator.decorate("Jacek Binkul"));
        System.out.println();

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
*/
    }
}
