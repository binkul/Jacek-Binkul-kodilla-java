package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
    @Autowired
    private Display display;
    @Autowired
    private DivideByZero divideByZero;

    public double add(double a, double b) {
        double result = a + b;

        display.displayValue(result);
        return result;
    }

    public double sub(double a, double b) {
        double result = a - b;

        display.displayValue(result);
        return result;
    }

    public double mul(double a, double b) {
        double result = a * b;

        display.displayValue(result);
        return result;
    }

    public double div(double a, double b) {
        double result;

        if ( b != 0) {
            result = a / b;
            display.displayValue(result);
        } else {
            result = Double.NaN;
            divideByZero.printDivideByZeroError();
        }

        return result;
    }

}
