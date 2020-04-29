package com.kodilla.patterns2.observer.blog;

import java.util.ArrayList;
import java.util.List;

public class Forum implements Observable {
    private final List<Observer> readers;
    private final List<Blog> blogs;
    private final String title;

    public Forum(String title) {
        this.readers = new ArrayList<>();
        this.blogs = new ArrayList<>();
        this.title = title;
    }

    public void addBlog(Blog blog) {
        blogs.add(blog);
        notifyReader(blog);
    }

    @Override
    public void attachReader(Observer reader) {
        readers.add(reader);
    }

    @Override
    public void detachReader(Observer reader) {
        readers.remove(reader);
    }

    @Override
    public void notifyReader(Blog blog) {
        for (Observer observer : readers) {
            observer.Update(blog);
        }
    }
}
