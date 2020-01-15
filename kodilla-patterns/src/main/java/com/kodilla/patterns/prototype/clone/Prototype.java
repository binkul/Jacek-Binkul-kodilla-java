package com.kodilla.patterns.prototype.clone;

public class Prototype<T> implements Cloneable {
    @Override
    public T clone() throws CloneNotSupportedException {
        return (T)super.clone();
    }
}
