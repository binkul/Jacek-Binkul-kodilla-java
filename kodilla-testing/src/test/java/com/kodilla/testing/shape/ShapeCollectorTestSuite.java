package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddNullShape() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        shapeCollector.addFigure(null);

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

        //Then
        Assert.assertEquals(triangle, result);
    }

    @Test
    public void testShowFigures() {
        //Given
        String name = "Triangle";
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape triangle = new Triangle(name, 10, 10);
        shapeCollector.addFigure(triangle);

        //When
        String result = shapeCollector.showFigures();

        //Then
        Assert.assertEquals("Triangle, field = 50,00\n", result);
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

        //Then
        Assert.assertEquals(50, triangleField, 0);
        Assert.assertEquals(100, squareField, 0);
        Assert.assertEquals(78.5, circleField, 0);
    }

}
