package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private static int uniqueID = 1;
    private final String userName;
    private final char userSex;
    private final LocalDate dateOfBirth;
    private final int postCount;
    private final int userID;

    public ForumUser(final String userName, final char userSex, final LocalDate dateOfBirth, final int postCount) {
        this.userName = userName;
        this.userSex = userSex;
        this.dateOfBirth = dateOfBirth;
        this.postCount = postCount;
        this.userID = uniqueID++;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "Forum User {" +
                "Name = '" + userName + "'" +
                ", Sex = " + (userSex == 'M' ? "Male" : "Female") +
                ", Date of birth = '" + dateOfBirth + "'" +
                ", Number of posts = " + postCount +
                '}';
    }
}
