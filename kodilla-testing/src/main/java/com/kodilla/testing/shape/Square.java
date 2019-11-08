package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    private String name;
    private double sideLength;

    public Square(String name, double sideLength) {
        this.name = name;
        this.sideLength = sideLength;
    }

    @Override
    public String getShapeName() {
        return this.name;
    }

    @Override
    public double getField() {
        return sideLength * sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return Double.compare(square.sideLength, sideLength) == 0 &&
                name.equals(square.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sideLength);
    }
}
