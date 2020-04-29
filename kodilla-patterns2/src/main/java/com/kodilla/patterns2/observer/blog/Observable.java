package com.kodilla.patterns2.observer.blog;

public interface Observable {
    void attachReader(Observer reader);
    void detachReader(Observer reader);
    void notifyReader(Blog blog);
}
