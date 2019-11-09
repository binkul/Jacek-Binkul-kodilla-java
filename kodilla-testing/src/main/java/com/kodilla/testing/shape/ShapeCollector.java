package com.kodilla.testing.shape;

import java.text.DecimalFormat;
import java.util.*;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        if (shape != null) {
            shapes.add(shape);
        }
    }

    public boolean removeFigure(Shape shape) {
        if (shape == null) {
            return false;
        } else if (shapes.size() == 0) {
            return false;
        } else if (shapes.contains(shape)) {
            shapes.remove(shape);
            return true;
        } else {
            return false;
        }
    }

    public Shape getFigure(int n) {
        Shape result = null;

        if (n >= 0 && n < shapes.size()) {
            result = shapes.get(n);
        }
        return result;
    }

    public String showFigures() {
        StringBuilder result = new StringBuilder();

        for (Shape shape : shapes) {
            result.append(shape.getShapeName());
            result.append(", field = ");
            result.append(getFiledToString(shape));
            result.append("\n");
        }
        return result.toString();
    }

    private String getFiledToString(Shape shape) {
        DecimalFormat df = new DecimalFormat("0.00");

        return df.format(shape.getField());
    }

    public int getSize() {
        return shapes.size();
    }
}
