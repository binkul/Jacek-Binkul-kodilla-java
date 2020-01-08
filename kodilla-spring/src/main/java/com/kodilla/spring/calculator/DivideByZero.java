package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class DivideByZero{

    public void printDivideByZeroError() {
        System.out.println("Dividing by zero ...");
    }
}
