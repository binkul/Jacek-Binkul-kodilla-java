package com.kodilla.patterns2.observer.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reader implements Observer {
    private final String firstname;
    private final String lastname;
    private final List<Blog> blogs;

    public Reader(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.blogs = new ArrayList<>();
    }

    @Override
    public void Update(Blog blog) {
        blogs.add(blog);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    @Override
    public String toString() {
        return "\nReader{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", blogs=" + "\n" + blogs.stream().map(Object::toString).collect(Collectors.joining("\n")) +
                '}';
    }
}
