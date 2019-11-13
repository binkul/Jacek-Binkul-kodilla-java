package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    private static List<ForumUser> forumUserCollection() {
        List<ForumUser> forumUser = new ArrayList<>();
        forumUser.add(new ForumUser("Jacek Binkul", 'M', LocalDate.of(1970, 4,2), 23));
        forumUser.add(new ForumUser("Muniek Kowalski", 'M', LocalDate.of(2000, 7,25), 5));
        forumUser.add(new ForumUser("Ewa Malinowska", 'F', LocalDate.of(1998, 5,30), 123));
        forumUser.add(new ForumUser("Alicja Gałkowska", 'F', LocalDate.of(2006, 11,13), 13));
        forumUser.add(new ForumUser("Antoni Macierewicz", 'M', LocalDate.of(1956, 3,1), 0));
        forumUser.add(new ForumUser("Agnieszka Dodzińska", 'F', LocalDate.of(1999, 6,12), 233));
        forumUser.add(new ForumUser("Arek Chudziński", 'M', LocalDate.of(1999, 11,13), 1));
        forumUser.add(new ForumUser("Pola Negri", 'F', LocalDate.of(2002, 10,23), 2));
        forumUser.add(new ForumUser("Tomek Chudakiewicz", 'M', LocalDate.of(1985, 5,1), 12));
        forumUser.add(new ForumUser("Beata Tuszkiewicz", 'F', LocalDate.of(1999, 8,24), 120));
        forumUser.add(new ForumUser("Lutek Waszczykowski", 'M', LocalDate.of(1995, 9,12), 20));
        return forumUser;
    }

    public static void main(String[] args) {

        Forum forum = new Forum(forumUserCollection());

        Map<Integer, ForumUser> theNewForumUserList = forum.getUserList().stream()
                .filter(ForumUser -> ForumUser.getUserSex() == 'M')
                .filter(ForumUser -> ForumUser.getDateOfBirth().until(LocalDate.now()).getYears() >= 20)
                .filter(ForumUser -> ForumUser.getPostCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, ForumUser -> ForumUser));

        System.out.println("## Found: " + theNewForumUserList.size() + " elements. ##");
        theNewForumUserList.entrySet().stream()
                .map(entry -> "Id=" + entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);
    }
}
