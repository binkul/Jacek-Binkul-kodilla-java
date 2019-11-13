package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 1;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Test
    public void testAddNullShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        shapeCollector.addFigure(null);
        System.out.format("Test #%d: add null shape ...\n", testCounter++);

        //Then
        Assert.assertEquals(0, shapeCollector.getSize());
    }

    @Test
    public void testAddShape() {

        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle("Triangle", 10.5, 12);

        //When
        shapeCollector.addFigure(triangle);
        System.out.format("Test #%d: add shape ...\n", testCounter++);

        //Then
        Assert.assertEquals(1, shapeCollector.getSize());
    }

    @Test
    public void testRemoveShapeNotExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle("Triangle", 10.5, 12);

        //When
        boolean result = shapeCollector.removeFigure(triangle);
        System.out.format("Test #%d: remove not existing shape ...\n", testCounter++);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle("Triangle", 10.5, 12);
        shapeCollector.addFigure(triangle);

        //When
        boolean result = shapeCollector.removeFigure(triangle);
        System.out.format("Test #%d: remove shape ...\n", testCounter++);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getSize());
    }

    @Test
    public void testGetShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle("Triangle", 10.5, 12);
        shapeCollector.addFigure(triangle);

        //When
        Shape result = shapeCollector.getFigure(0);
        System.out.format("Test #%d: get shape ...\n", testCounter++);

        //Then
        Assert.assertEquals(triangle, result);
    }

    @Test
    public void testShowFigures() {
        //Given
        String name = "Triangle";
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle(name, 1.25, 1.0);
        shapeCollector.addFigure(triangle);

        //When
        String result = shapeCollector.showFigures();
        System.out.format("Test #%d: show all shapes from collection ...\n", testCounter++);

        //Then
        Assert.assertEquals("Triangle(a: 1.25, h: 1.0)\n", result);
    }

    @Test
    public void testField() {
        //Given
        Shape triangle = new Triangle("Triangle", 10, 10);
        Shape square = new Square("Square", 10);
        Shape circle = new Circle("Circle", 5);

        //When
        double triangleField = triangle.getField();
        double squareField = square.getField();
        double circleField = circle.getField();
        System.out.format("Test #%d: fields of shapes calculation ...\n", testCounter++);

        //Then
        Assert.assertEquals(50, triangleField, 0);
        Assert.assertEquals(100, squareField, 0);
        Assert.assertEquals(78.54, circleField, 0.01);
    }
}
