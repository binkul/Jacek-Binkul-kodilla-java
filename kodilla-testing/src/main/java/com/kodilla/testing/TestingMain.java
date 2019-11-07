package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){

        // Task 6.2.
        if (Calculator.add(340, 420) == 760) {
            System.out.println("Method Calculator.add(int a, int b) is ok.");
        } else {
            System.out.println("Method Calculator.add(int a, int b) is wrong! Correct it !");
        }

        if (Calculator.subtract(700, 352) == 348) {
            System.out.println("Method Calculator.subtract(int a, int b) is ok.");
        } else {
            System.out.println("Method Calculator.subtract(int a, int b) is wrong! Correct it!");
        }
    }
}
