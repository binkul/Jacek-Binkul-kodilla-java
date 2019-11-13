package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        if (shape != null) {
            shapes.add(shape);
        }
    }

    public boolean removeFigure(Shape shape) {
        return shape != null && shapes.remove(shape);
    }

    public Shape getFigure(int n) {

        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        } else {
            return null;
        }
    }

    public String showFigures() {
        StringBuilder result = new StringBuilder();

        for (Shape shape : shapes) {
            result.append(shape.toString());
            result.append("\n");
        }
        return result.toString();
    }

    public int getSize() {
        return shapes.size();
    }
}
