package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
    static final Random random = new Random();

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }

    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testOddNumbersExterminatorNullList() {
        List<Integer> result;

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        result = oddNumbersExterminator.exterminate(null);
        System.out.println("Test, when List<Integer> is null ...");
        //Then
        Assert.assertNull(result);
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        ArrayList<Integer> numbers = new ArrayList<>();
        List<Integer> result;

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        result = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Test, when List<Integer> is empty ...");
        //Then
        Assert.assertNull(result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        ArrayList<Integer> numbers = new ArrayList<>();
        List<Integer> result;
        boolean oddNumberFound = false;
        int maxNumbers = 500;

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        for (int i = 0; i < maxNumbers; i++) {
            numbers.add(random.nextInt(1000));
        }
        //When
        result = oddNumbersExterminator.exterminate(numbers);
        System.out.format("Test, when List<Integer> is filled with %d random numbers ...\n", maxNumbers);
        //Then
        for (Integer number : result) {
            if (number % 2 != 0) {
                oddNumberFound = true;
                break;
            }
        }
        System.out.format("Found %d even numbers and %d odd numbers from %d entered ...\n", result.size(), maxNumbers - result.size(), maxNumbers);
        Assert.assertFalse(oddNumberFound);
    }
}
