package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final String name;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int postCount;
    private final int id;

    public ForumUser(final String name, final char sex, final LocalDate dateOfBirth, final int postCount, final int id) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.postCount = postCount;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getUserID() {
        return id;
    }

    @Override
    public String toString() {
        return "Forum User {" +
                "Name = '" + name + "'" +
                ", Sex = " + (sex == 'M' ? "Male" : "Female") +
                ", Date of birth = '" + dateOfBirth + "'" +
                ", Number of posts = " + postCount +
                '}';
    }
}
