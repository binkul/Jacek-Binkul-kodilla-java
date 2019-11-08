package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
    private static final Random random = new Random();

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
        System.out.println("Test empty list ...");
        //Then
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        List<Integer> numbers;
        List<Integer> result;
        boolean oddNumberFound;
        int maxNumbers = 500;

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        numbers = fillNumbersCollection(maxNumbers);

        //When
        result = oddNumbersExterminator.exterminate(numbers);
        System.out.format("Test, when List<Integer> is filled with %d random numbers ...\n", maxNumbers);

        //Then
        oddNumberFound = checkForOddElements(result);
        System.out.format("Found %d even numbers and %d odd numbers from %d entered ...\n", result.size(), maxNumbers - result.size(), maxNumbers);
        Assert.assertFalse(oddNumberFound);
    }

    private List<Integer> fillNumbersCollection(int maxNumbers) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < maxNumbers; i++) {
            result.add(random.nextInt(1000));
        }
        return result;
    }

    private boolean checkForOddElements(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}
