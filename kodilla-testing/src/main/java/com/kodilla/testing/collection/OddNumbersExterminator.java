package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    OddNumbersExterminator() {
    }

    List<Integer> exterminate(ArrayList<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();

        if (numbers == null) {
            return null;
        }

        if (numbers.size() > 0) {
           for (Integer number : numbers) {
                if (number % 2 == 0) {
                    evenNumbers.add(number);
                }
            }
        } else {
            return null;
        }

        return evenNumbers;
    }
}
