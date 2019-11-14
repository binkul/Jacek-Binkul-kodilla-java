package com.kodilla.stream.array;

import java.util.stream.IntStream;

public class Average implements ArrayOperations {

    public double getAverage(final int[] numbers) {

        printNumbers(numbers);
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average().getAsDouble();
    }

    private void printNumbers(final int[] numbers) {
        IntStream.range(0, numbers.length)
                .forEach(n -> System.out.println(numbers[n]));
// or
// .map(n -> numbers[n])
// .forEach(System.out::println);
    }
}
