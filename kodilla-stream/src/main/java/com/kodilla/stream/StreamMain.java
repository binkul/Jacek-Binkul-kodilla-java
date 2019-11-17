package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMain {
    private static List<ForumUser> forumUserCollection() {
        List<ForumUser> forumUser = new ArrayList<>();
        forumUser.add(new ForumUser("Jacek Binkul", 'M', LocalDate.of(1970, 4,2), 23, 1));
        forumUser.add(new ForumUser("Muniek Kowalski", 'M', LocalDate.of(2000, 7,25), 5, 2));
        forumUser.add(new ForumUser("Ewa Malinowska", 'F', LocalDate.of(1998, 5,30), 123, 3));
        forumUser.add(new ForumUser("Alicja Gałkowska", 'F', LocalDate.of(2006, 11,13), 13, 4));
        forumUser.add(new ForumUser("Antoni Macierewicz", 'M', LocalDate.of(1956, 3,1), 0, 5));
        forumUser.add(new ForumUser("Agnieszka Dodzińska", 'F', LocalDate.of(1999, 6,12), 233, 6));
        forumUser.add(new ForumUser("Arek Chudziński", 'M', LocalDate.of(1999, 11,13), 1, 7));
        forumUser.add(new ForumUser("Pola Negri", 'F', LocalDate.of(2002, 10,23), 2, 8));
        forumUser.add(new ForumUser("Tomek Chudakiewicz", 'M', LocalDate.of(1985, 5,1), 12, 9));
        forumUser.add(new ForumUser("Beata Tuszkiewicz", 'F', LocalDate.of(1999, 8,24), 120, 10));
        forumUser.add(new ForumUser("Lutek Waszczykowski", 'M', LocalDate.of(1995, 9,12), 20, 11));
        return forumUser;
    }

    public static void main(String[] args) {

        Forum forum = new Forum(forumUserCollection());

        Map<Integer, ForumUser> theNewForumUserList = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().until(LocalDate.now()).getYears() >= 20)
                .filter(forumUser -> forumUser.getPostCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, Function.identity()));

        System.out.println("## Found: " + theNewForumUserList.size() + " elements. ##");
        theNewForumUserList.entrySet().stream()
                .map(entry -> "Id=" + entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);


/*
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach((s) -> System.out.println(s));
*/

/*
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(" ") + 2) + ".")
                .filter(s -> s.charAt(0) == 'M')
                .forEach(s -> System.out.println(s));

        System.out.println();
*/

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
