package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] testInt = {2, 200, 30, 40, 51, 11, 23, 8, 87, 10, 56, 76, 36, 27, 19, 89, 87, 90, 47, 20};

        //When
        Average average = new Average();
        double avrInt = average.getAverage(testInt);

        //Then
        Assert.assertEquals(50.45, avrInt, 0.001);
    }
}
