package com.kodilla.testing.shape;

import java.text.DecimalFormat;
import java.util.Objects;

public class Triangle implements Shape {
    private String name;
    private double baseLength;
    private double height;

    public Triangle(String name, double baseLength, double height) {
        this.name = name;
        this.baseLength = baseLength;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return this.name;
    }

    @Override
    public double getField() {
        return 0.5 * baseLength * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.baseLength, baseLength) == 0 &&
                Double.compare(triangle.height, height) == 0 &&
                name.equals(triangle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, baseLength, height);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.name + ", field = " + df.format(getField());
    }
}
