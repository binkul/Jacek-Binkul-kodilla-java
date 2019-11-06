package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){

        // from submodul
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");
        System.out.println("Pull Request first time");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK\n");
        } else {
            System.out.println("Error!\n");
        }

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
