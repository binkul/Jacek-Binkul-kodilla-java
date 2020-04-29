package com.kodilla.patterns2.observer.blog;

import java.time.LocalDate;
import java.util.Objects;

public class Blog {
    private final String title;
    private final String content;
    private final LocalDate date;

    public Blog(String title, String content, LocalDate date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Blog)) return false;
        Blog blog = (Blog) o;
        return Objects.equals(title, blog.title) &&
                Objects.equals(content, blog.content) &&
                Objects.equals(date, blog.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, date);
    }
}
